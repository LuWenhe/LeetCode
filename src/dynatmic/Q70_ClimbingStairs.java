package dynatmic;

public class Q70_ClimbingStairs {

    public int climbStairs2(int n) {
        // dp[i]表示爬到第i级台阶的方案数
        int[] dp = new int[n + 1];

        // 爬到第0级台阶只有一种方案
        dp[0] = 1;
        // 爬到第1级台阶只有一种方案
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            // 爬到第i级台阶的方案数是爬到第i-1级台阶和爬到第i-2级台阶的方案数之和
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return dp(memo, n);
    }

    // 定义：爬到第 n 级台阶的方法个数为 dp(n)
    int dp(int[] memo, int n) {
        // base case
        if (n == 1 || n == 2) {
            return n;
        }

        if (memo[n] > 0) {
            return memo[n];
        }

        // 状态转移方程：
        // 爬到第 n 级台阶的方法个数等于爬到 n - 1 的方法个数和爬到 n - 2 的方法个数之和。
        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        int res = new Q70_ClimbingStairs().climbStairs(2);
        System.out.println(res);
    }

}
