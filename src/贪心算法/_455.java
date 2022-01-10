package 贪心算法;

import java.util.Arrays;

public class _455 {
    class Solution {
        /*两个for循环*/
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int ans = 0;
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if (s[j] >= g[i]) {
                        ans++;
                        s[j] = -1;
                        break;
                    }
                }
            }
            return ans;
        }

        // 优化后一个for循环
        public int findContentChildren2(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int start = 0;
            int count = 0;
            for (int i = 0; i < s.length && start < g.length; i++) {
                if (s[i] >= g[start]) {
                    start++;
                    count++;
                }
            }
            return count;
        }
    }
}