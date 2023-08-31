package dynatmic;

public class Q198_HouseRobber {

    /**
     * 由于不可以在相邻的房屋闯入, 所以在当前位置 n 房屋可盗窃的最大值,
     * 要么就是 n-1 房屋可盗窃的最大值, 要么就是 n-2 房屋可盗窃的最大值加上当前房屋的值, 二者之间取最大值
     */
    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len + 1];

        dp[0] = 0;
        // 位置1的最大值就是nums[0]
        dp[1] = nums[0];

        // dp[2]对应的是位置1可偷窃的最大值, 或者是位置0可偷窃的最大值加上当前房屋的值
        for(int i = 2; i <= len; i++) {
            int a = dp[i - 1];
            int b = dp[i - 2] + nums[i - 1];

            dp[i] = Math.max(a, b);
        }

        return dp[len];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int rob = new Q198_HouseRobber().rob(nums);
        System.out.println(rob);
    }

}
