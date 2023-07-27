package array.Prefix;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 */
public class Q304_RangeSumQuery2DImmutable {

    // preMatrix[i][j]表示矩阵matrix从[0,0]到[i-1,j-1]的子矩形所有元素之和
    private final int[][] preMatrix;

    public Q304_RangeSumQuery2DImmutable(int[][] matrix) {
        int m = matrix.length;      // 行数
        int n = matrix[0].length;   // 列数
        preMatrix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // matrix中的i和j需要将preMatrix中的i和j各减去1
                preMatrix[i][j] = preMatrix[i - 1][j] + preMatrix[i][j - 1] - preMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                preMatrix[i + 1][j + 1] = preMatrix[i][j + 1] + preMatrix[i + 1][j] - preMatrix[i][j] + matrix[i][j];
//            }
//        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preMatrix[row2 + 1][col2 + 1] - preMatrix[row2 + 1][col1] - preMatrix[row1][col2 + 1] + preMatrix[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        Q304_RangeSumQuery2DImmutable rangeSumQuery2DImmutable = new Q304_RangeSumQuery2DImmutable(matrix);
        int sum1 = rangeSumQuery2DImmutable.sumRegion(2, 1, 4, 3);
        int sum2 = rangeSumQuery2DImmutable.sumRegion(1, 1, 2,2);
        int sum3 = rangeSumQuery2DImmutable.sumRegion(1, 2, 2, 4);
        System.out.println(sum1 + " " + sum2 + " " + sum3);
    }

}
