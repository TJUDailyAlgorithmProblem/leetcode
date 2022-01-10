package 回溯法;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _77 {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (n == 0 || k == 0) return res;
            Deque<Integer> deque = new ArrayDeque<>(k);
            int[] arr = new int[n + 1];
            dfs(1, n, k, res, deque);
            return res;
        }

        public void dfs(int begin, int n, int k, List<List<Integer>> res, Deque<Integer> deque) {
            if (deque.size() == k) {
                res.add(new ArrayList<>(deque));
                return;
            }
            for (int i = begin; i <= n - (k - deque.size()) + 1; i++) {
                deque.addLast(i);
                dfs(i + 1, n, k, res, deque);
                deque.removeLast();
            }
        }
    }
}
