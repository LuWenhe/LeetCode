package array.simulation;

import java.util.ArrayList;
import java.util.List;

public class Q54_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int width = matrix[0].length, height = matrix.length;
        int leftBound = 0, rightBound = width - 1;
        int upperBound = 0, lowerBound = height - 1;

        while (res.size() < width * height) {
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    res.add(matrix[upperBound][i]);
                }

                upperBound++;
            }

            if (rightBound >= leftBound) {
                for (int i = upperBound; i <= lowerBound; i++) {
                    res.add(matrix[i][rightBound]);
                }

                rightBound--;
            }

            if (lowerBound >= upperBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    res.add(matrix[lowerBound][i]);
                }

                lowerBound--;
            }

            if (leftBound <= rightBound) {
                for (int i = lowerBound; i >= upperBound; i--) {
                    res.add(matrix[i][leftBound]);
                }

                leftBound++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = new Q54_SpiralMatrix().spiralOrder(matrix);
        System.out.println(list);
    }

}
