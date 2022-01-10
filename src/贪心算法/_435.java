package 贪心算法;

import java.util.Arrays;

public class _435 {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length < 2) {
                return 0;
            }
            int ans = 0;
            Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[1], o2[1]));
            int start = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < start) {
                    ans++;
                    intervals[i][1] = start;
                }
                start = intervals[i][1];
            }
            return ans;
        }
    }
}
