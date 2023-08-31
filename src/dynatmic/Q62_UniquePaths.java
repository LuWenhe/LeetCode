package dynatmic;

public class Q62_UniquePaths {

    public int uniquePaths(int m, int n) {
        // dp[i][j]表示从左上角走到坐标[i,j]的路径数量, i为行, j为列
        int[][] dp = new int[m][n];

        // 因为只能往下和往右走, 最左边和最上面的网格都只有1条路, 所以边界条件dp[i][0]=1, dp[0][j]=1
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; ++j) {
            dp[0][j] = 1;
        }

        // 从左上角走到左边[i,j], 只能从坐标[i-1,j]出发向下走一步，或者从坐标[i,j-1]出发向右走一步
        // 只要知道从左上角走到[i-1,j]的路径数目dp[i-1][j]和从左上角走到[i,j-1]的路径数目dp[i][j-1],
        // 就可以推算出从左上角走到[i,j]的路径数目dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        int res = new Q62_UniquePaths().uniquePaths(m, n);
        System.out.println(res);
    }

}
