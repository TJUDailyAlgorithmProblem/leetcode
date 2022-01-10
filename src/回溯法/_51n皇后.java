package 回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _51n皇后 {
    class Solution {
        List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] chessboard = new char[n][n];
            for (char[] c : chessboard) {
                Arrays.fill(c, '.');
            }
            dfs(chessboard, 0, n);
            return res;
        }

        private void dfs(char[][] chessboard, int row, int n) {
            if (row == n) {
                res.add(Array2List(chessboard));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (isValid(chessboard, row, i, n)) {
                    chessboard[row][i] = 'Q';
                    dfs(chessboard, row + 1, n);
                    chessboard[row][i] = '.';
                }
            }
        }

        public List Array2List(char[][] chessboard) {
            List<String> list = new ArrayList<>();
            for (char[] c : chessboard) {
                list.add(String.copyValueOf(c));
            }
            return list;
        }

        public boolean isValid(char[][] chessboard, int row, int col, int n) {
            // 检查列
            for (int i = 0; i < row; ++i) { // 相当于剪枝
                if (chessboard[i][col] == 'Q') {
                    return false;
                }
            }
            // 检查45度对角线
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (chessboard[i][j] == 'Q') {
                    return false;
                }
            }

            // 检查135度对角线
            for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
                if (chessboard[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
}
