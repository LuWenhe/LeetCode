package Array;

import java.util.ArrayList;
import java.util.List;

public class Q566_ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int length = mat.length, width = mat[0].length;

        if (length * width != r * c || (length * width % c > 0)) {
            return mat;
        }

        int[][] newMatrix = new int[r][c];
        List<Integer> list = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                list.add(mat[i][j]);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newMatrix[i][j] = list.get(index++);
            }
        }

        return newMatrix;
    }

    public int[][] matrixReshape2(int[][] mat, int r, int c) {
        // 如果mat是2行3列的二维数组, 那么m为2, n为3
        int m = mat.length, n = mat[0].length;

        if (m * n != r * c || (m * n % c > 0)) {
            return mat;
        }

        int[][] newMatrix = new int[r][c];
        // a和b表示转换后二维数组的行和列
        int a = 0, b = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 如果新的列值大于n, 则置为0, 同时新的行值加1
                if (b >= n) {
                    b = 0;
                    a++;
                }

                newMatrix[i][j] = mat[a][b];
                b++;
            }
        }

        return newMatrix;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6}};
        int r = 3, c = 2;

        int[][] reshape = new Q566_ReshapeTheMatrix().matrixReshape2(mat, r, c);

        System.out.println(reshape.length + " " + reshape[0].length);

        for (int[] ints : reshape) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
    }

}
