package dynatmic;

import java.util.Arrays;

public class Q300_LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];

        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 寻找 nums[0..j-1] 中比 nums[i] 小的元素
                if (nums[i] > nums[j]) {
                    // 把 nums[i] 接在后面，即可形成长度为 dp[j] + 1，
                    // 且以 nums[i] 为结尾的递增子序列
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;

        for (int j : dp) {
            res = Math.max(res, j);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int res = new Q300_LongestIncreasingSubsequence().lengthOfLIS(nums);
        System.out.println(res);
    }

}
