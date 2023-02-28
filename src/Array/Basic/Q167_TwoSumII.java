package Array.Basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 167.两数之和II-输入有序数组
 */
public class Q167_TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int num = target - numbers[i];

            if (hashMap.containsKey(num)) {
                return new int[]{hashMap.get(num), i + 1};
            }

            hashMap.put(numbers[i], i + 1);
        }

        return new int[12];
    }

    public int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[1];
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] nums = new Q167_TwoSumII().twoSum2(numbers, target);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
