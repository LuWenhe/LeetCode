package dynatmic;

public class Q63_UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean isLeftAlive = false, isTopAlive = false;

        // 如果左边界的第i行有障碍物, 则无法达到第i+1,...,i+n行, 即到达[i,0]的路径为0
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                isLeftAlive = true;
            }

            dp[i][0] = isLeftAlive ? 0 : 1;
        }

        // 如果上边界的第i列有障碍物, 则无法达到第i+1,...,i+n列, 即到达[0,i]的路径为0
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                isTopAlive = true;
            }

            dp[0][i] = isTopAlive ? 0 : 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }

                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 数组索引偏移一位，dp[0][..] dp[..][0] 代表 obstacleGrid 之外
        // 定义：到达 obstacleGrid[i][j] 的路径条数为 dp[i-1][j-1]
        int[][] dp = new int[m + 1][n + 1];

        // base case：如果没有障碍物，起点到起点的路径条数就是 1
        dp[1][1] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    // 跳过 base case
                    continue;
                }

                if (obstacleGrid[i - 1][j - 1] == 1) {
                    // 跳过障碍物的格子
                    continue;
                }

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // 返回到达 obstacleGrid[m-1][n-1] 的路径数量
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int res = new Q63_UniquePathsII().uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }

}
