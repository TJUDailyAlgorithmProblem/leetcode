package 贪心算法;

import java.util.Arrays;

public class _452 {
    class Solution {
        public int findMinArrowShots(int[][] points) {
//            Arrays.sort(points, new Comparator<int[]>() {
//                public int compare(int[] point1, int[] point2) {
//                    if (point1[1] > point2[1]) {
//                        return 1;
//                    } else if (point1[1] < point2[1]) {
//                        return -1;
//                    } else {
//                        return 0;
//                    }
//                }
//            });
            Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));
//            Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
            int ans = 1;
            int axis = points[0][1];
            for (int i = 1; i < points.length; i++) {
                if (axis < points[i][0]) {
                    ans++;
                    axis = points[i][1];
                }
            }
            return ans;
        }
    }
}
