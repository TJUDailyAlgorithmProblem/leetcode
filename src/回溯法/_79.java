package 回溯法;

public class _79 {
    class Solution {
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited;
        char[][] board;
        char[] charArray;

        public boolean exist(char[][] board, String word) {
            this.board = board;
            visited = new boolean[board.length][board[0].length];
            charArray = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int begin, int x, int y) {
            if (begin == charArray.length - 1) {
                return board[x][y] == charArray[begin];
            }
            if (board[x][y] == charArray[begin]) {
                visited[x][y] = true;
                for (int[] ints : direction) {
                    int dx = x + ints[0];
                    int dy = y + ints[1];
                    if (inArea(dx, dy) && !visited[dx][dy]) {
                        if (dfs(begin + 1, dx, dy)) {  // TODO: 2021/12/9 ++begin不行，begin+1就可
                            return true;
                        }
                    }
                }
                visited[x][y] = false;
            }
            return false;
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
        }
    }
}
