package 贪心算法;

import java.util.LinkedList;
import java.util.List;

public class _763 {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            List<Integer> ans = new LinkedList<>();
            char[] charArr = s.toCharArray();
            int[] hash = new int[27];
            for (int i = 0; i < charArr.length; i++) {
                hash[charArr[i] - 'a'] = i;
            }
            int idx = 0;
            int last = -1;
            for (int i = 0; i < charArr.length; i++) {
                idx = Math.max(idx, hash[charArr[i] - 'a']);
                if (idx == i) {
                    ans.add(i - last);
                    last = i;
                }
            }
            return ans;
        }
    }
}
