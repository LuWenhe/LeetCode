package dynatmic;

public class Q53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        // dp[i]表示以nums[i]结尾的最大的子数组的和
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        // 状态转移方程
        for (int i = 1; i < nums.length; i++) {
            // 第i个位置的数字
            int num = nums[i];
            // // dp[i-1]表示第i-1个位置的子数组的最大和
            int dpNum = nums[i] + dp[i - 1];
            // 如果dpNum大于num, 则将第i个位置与前面相邻的子数组连接，形成一个和更大的子数组
            // 否则不与前面的子数组连接, 自己单独作为一个子数组
            dp[i] = Math.max(num, dpNum);
        }

        int res = Integer.MIN_VALUE;

        for (int d : dp) {
            if (d > res) {
                res = d;
            }

            System.out.print(d + " ");
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = new Q53_MaximumSubarray().maxSubArray(nums);
        System.out.println(res);
    }

}
