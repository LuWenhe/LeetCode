package dynatmic;

public class Q53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int dpNum = nums[i] + dp[i - 1];
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
