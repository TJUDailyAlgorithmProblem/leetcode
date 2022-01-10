package 回溯法;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _93 {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            if (s.length() < 4 || s.length() > 20) {
                return res;
            }
            int len = s.length();
            Deque<String> deque = new ArrayDeque<>();
            int splitTime = 0;
            dfs(len, 0, s, res, splitTime, deque);
            return res;
        }

        public void dfs(int len, int begin, String s, List<String> res, int split, Deque<String> deque) {
            if (len == begin) {
                if (split == 4) {
                    res.add(String.join(".", deque));
                }
                return;
            }
            if (len - begin < (4 - split) || len - begin > 3 * (4 - split)) {
                return;
            }
            for (int i = 0; i < 3; i++) {
                if (begin + i >= len) break;
                int ip = isIp(s, begin, begin + i);
                if (ip != -1) {
                    deque.addLast(ip + "");
                    dfs(len, begin + i + 1, s, res, split + 1, deque);
                    deque.removeLast();
                }
            }
        }

        private int isIp(String s, int left, int right) {
            int len = right - left + 1;
            if (len > 1 && s.charAt(left) == '0') {
                return -1;
            }
            int res = 0;
            for (int i = left; i <= right; i++) {
                res = s.charAt(i) - '0' + res * 10;
            }
            if (res > 255) {
                return -1;
            }
            return res;
        }
    }
}
