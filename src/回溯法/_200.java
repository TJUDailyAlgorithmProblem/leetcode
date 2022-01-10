package 回溯法;

public class _200 {
    class Solution {
        public int numIslands(char[][] grid) {
            int ans = 0;
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        dfs(i, j, grid, visited);
                        ans++;
                    }
                }
            }
            return ans;
        }

        private void dfs(int x, int y, char[][] grid, boolean[][] visited) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0' || visited[x][y]) {
                return;
            }
            visited[x][y] = true;
            dfs(x - 1, y, grid, visited);
            dfs(x + 1, y, grid, visited);
            dfs(x, y + 1, grid, visited);
            dfs(x, y - 1, grid, visited);
        }
    }
}
