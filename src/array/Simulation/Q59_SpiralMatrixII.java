package array.Simulation;

public class Q59_SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int leftBound = 0, rightBound = n - 1;
        int upperBound = 0, lowerBound = n - 1;

        int num = 1;

        while (num <= Math.pow(n, 2)) {
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    matrix[upperBound][i] = num++;
                }

                upperBound++;
            }

            if (leftBound <= rightBound) {
                for (int i = upperBound; i <= lowerBound; i++) {
                    matrix[i][rightBound] = num++;
                }

                rightBound--;
            }

            if (upperBound <= lowerBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    matrix[lowerBound][i] = num++;
                }

                lowerBound--;
            }

            if (leftBound <= rightBound) {
                for (int i = lowerBound; i >= upperBound; i--) {
                    matrix[i][leftBound] = num++;
                }

                leftBound++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] res = new Q59_SpiralMatrixII().generateMatrix(3);

        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

}
