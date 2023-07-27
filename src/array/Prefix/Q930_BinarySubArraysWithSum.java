package array.Prefix;

import java.util.HashMap;
import java.util.Map;

public class Q930_BinarySubArraysWithSum {

    public int[] runningSum(int[] nums) {
        int[] preSum = new int[nums.length + 1];

        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        return preSum;
    }

    public int numSubArraysWithSum(int[] nums, int goal) {
        int[] runningSum = runningSum(nums);
        int count = 0;

        for (int i = 0; i < runningSum.length; i++) {
            for (int j = i + 1; j < runningSum.length; j++) {
                int sum = runningSum[j] - runningSum[i];

                if (sum == goal) {
                    count++;
                }
            }
        }

        return count;
    }

    public int numSubArraysWithSum2(int[] nums, int goal) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int count = 0, sum = 0;

        for (int num : nums) {
            sum += num;

            if (hashMap.containsKey(sum - goal)) {
                count += hashMap.get(sum - goal);
            }

            // 将前缀和在Map中出现的次数加1
            Integer sCount = hashMap.getOrDefault(sum, 0);
            hashMap.put(sum, sCount + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0};
        int goal = 0;
        int count = new Q930_BinarySubArraysWithSum().numSubArraysWithSum2(nums, goal);
        System.out.println(count);
    }

}
