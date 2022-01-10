package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class _784 {
    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> letterCasePermutation(String S) {
            char[] chs = S.toCharArray();
            int n = chs.length;
            dfs(chs, n, 0);
            return res;
        }

        private void dfs(char[] chs, int n, int begin) {
            res.add(new String(chs));
            for (int i = begin; i < n; i++) {
                if (!Character.isDigit(chs[i])) {
                    char tmp = chs[i];
                    chs[i] = (char) (chs[i] - 'a' >= 0 ? chs[i] - 32 : chs[i] + 32);
                    dfs(chs, n, i + 1);
                    chs[i] = tmp;
                }
            }
        }
    }
}
