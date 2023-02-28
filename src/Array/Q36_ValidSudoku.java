package Array;

import java.util.HashMap;
import java.util.Map;

public class Q36_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                //横行
                for (int row = 0; row < 9; row++) {
                    if (row != j && board[i][j] == board[i][row]) {
                        return false;
                    }
                }

                //纵行
                for (int col = 0; col < 9; col++) {
                    if (col != i && board[col][j] == board[i][j]) {
                        return false;
                    }
                }

                int srlen = (i) / 3 * 3;
                int sclen = (j) / 3 * 3;

                //小格子内
                for (int sr = srlen; sr < srlen + 3; sr++) {
                    for (int sc = sclen; sc < sclen + 3; sc++) {
                        if (board[sr][sc] == board[i][j] && (sr != i && sc != j) && board[sr][sc] != '.') {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        // 遍历每一行
        for (char[] chars : board) {
            Map<Character, Integer> hashMap = new HashMap<>();

            for (char aChar : chars) {
                // 如果有重复
                if (hashMap.containsKey(aChar)) {
                    return false;
                }

                if (aChar != '.') {
                    hashMap.put(aChar, 1);
                }
            }
        }

        // 遍历每一列
        for (int i = 0; i < board[0].length; i++) {
            Map<Character, Integer> hashMap = new HashMap<>();

            for (char[] chars : board) {
                if (hashMap.containsKey(chars[i])) {
                    return false;
                }

                if (chars[i] != '.') {
                    hashMap.put(chars[i], 1);
                }
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                int m = i / 3 * 3;
                int n = j / 3 * 3;

                Map<Character, Integer> hashMap = new HashMap<>();

                for (int i1 = m; i1 < m + 3; i1++) {
                    for (int j1 = n; j1 < n + 3; j1++) {
                        if (hashMap.containsKey(board[i1][j1])) {
                            return false;
                        }

                        if (board[i1][j1] != '.') {
                            hashMap.put(board[i1][j1], 1);
                        }

                        System.out.print("(" + i1 + "," + j1 + ") ");
                    }

                    System.out.println();
                }

                System.out.println();
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        char[][] board2 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean isValidSudoku = new Q36_ValidSudoku().isValidSudoku2(board2);
        System.out.println(isValidSudoku);
    }

}
