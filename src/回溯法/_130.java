package 回溯法;

public class _130 {
    class Solution {
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public void solve(char[][] board) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean isEdge = i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1;
                    if (board[i][j] == 'O' && isEdge) {
                        dfs(i, j, visited, board);
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                    if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void dfs(int x, int y, boolean[][] visited, char[][] board) {
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == 'X' || board[x][y] == '#') {
                return;
            }
            board[x][y] = '#';
            for (int[] ints : dir) {
                int dx = x + ints[0];
                int dy = y + ints[1];
                dfs(dx, dy, visited, board);
            }
        }
    }
}
