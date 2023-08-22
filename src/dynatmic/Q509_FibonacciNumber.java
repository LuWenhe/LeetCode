package dynatmic;

/**
 * 0 1 1 2 3
 */
public class Q509_FibonacciNumber {

    public int fib2(int n) {
        if (n == 0) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int fib(int n) {
        int[] memo = new int[n + 1];
        return dp(memo, n);
    }

    public int dp(int[] memo, int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        int fib = new Q509_FibonacciNumber().fib2(3);
        System.out.println(fib);
    }

}
