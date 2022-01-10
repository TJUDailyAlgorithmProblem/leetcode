package 回溯法;

public class _733 {
    class Solution {

//            public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//                return dfs(image, sr, sc, newColor, image[sr][sc]);
//            }
//
//            public int[][] dfs(int[][] image, int i, int j, int newColor, int num){
//                if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]==newColor || image[i][j]!=num){
//
//                }else{
//                    int temp=image[i][j];
//                    image[i][j]=newColor;
//                    dfs(image, i+1, j, newColor, temp);
//                    dfs(image, i-1, j, newColor, temp);
//                    dfs(image, i, j+1, newColor, temp);
//                    dfs(image, i, j-1, newColor, temp);
//
//                }
//                return image;
//    }
//

        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            dfs(image, sr, sc, newColor, image[sr][sc]);
            return image;
        }

        private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
            if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor || newColor == oldColor) {
                return;
            }
            image[sr][sc] = newColor;
            for (int[] ints : direction) {
                dfs(image, sr + ints[0], sc + ints[1], newColor, oldColor);
            }
        }
    }
}
