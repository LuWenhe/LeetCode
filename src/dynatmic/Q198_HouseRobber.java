package dynatmic;

public class Q198_HouseRobber {

    public int rob(int[] nums) {
        return dp(nums, 0);
    }

    public int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }

        // 不抢，去下家
        int dp = dp(nums, start + 1);
        // 抢, 去下下家
        int b = nums[start] + dp(nums, start + 2);
        return Math.max(dp, b);
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // 子问题：
        // f(k) = 偷 [0..k) 房间中的最大金额

        // f(0) = 0
        // f(1) = nums[0]
        // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }

        int N = nums.length;
        int[] dp = new int[N+1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int k = 2; k <= N; k++) {
            int a = dp[k - 1];
            int b = nums[k - 1] + dp[k - 2];

            dp[k] = Math.max(a, b);
        }

        return dp[N];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int rob = new Q198_HouseRobber().rob2(nums);
        System.out.println(rob);
    }

}
