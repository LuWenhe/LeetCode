package array.Prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * 560.和为K的子数组
 */
public class Q560_SubarraySumEqualsK {

    public int[] runningSum(int[] nums) {
        int[] preSum = new int[nums.length + 1];

        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        return preSum;
    }

    public int subarraySum(int[] nums, int k) {
        int[] runningSum = runningSum(nums);
        int count = 0;

        for (int i = 0; i < runningSum.length - 1; i++) {
            for (int j = i + 1; j < runningSum.length; j++) {
                int sum = runningSum[j] - runningSum[i];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 扫描一遍数组, 使用map记录出现同样的和的次数, 对每个i计算累计和sum并判断map内是否有sum-k
     */
    public int subarraySum2(int[] nums, int k) {
        // 键存放的是数组中第i个位置的前缀和, 值存放的是前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;

        for (int num : nums) {
            // 得到数组中第i个位置的前缀和
            sum += num;

            // 数组中不同位置的前缀和相减就是两个位置之间所有元素的和, 因此sum-k就是看看Map中是否存在另一个位置的前缀和
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // 将前缀和在Map中出现的次数加1
            Integer sCount = map.getOrDefault(sum, 0);
            map.put(sum, sCount + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        int k = 3;
        int num = new Q560_SubarraySumEqualsK().subarraySum2(nums, k);
        System.out.println(num);
    }

}
