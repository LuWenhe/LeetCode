package dynatmic;

public class Q64_MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        dp[1][1] = grid[0][0];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }

                if (i == 1) {
                    dp[i][j] = dp[i][j - 1] + grid[i - 1][j - 1];
                    continue;
                }

                if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + grid[i - 1][j - 1];
                    continue;
                }

                dp[i][j] = Math.min(dp[i][j - 1] + grid[i - 1][j - 1], dp[i - 1][j] + grid[i - 1][j - 1]);
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int res = new Q64_MinimumPathSum().minPathSum(grid);
        System.out.println(res);
    }

}
