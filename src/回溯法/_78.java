package 回溯法;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _78 {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            if (len == 0) return res;
            Deque<Integer> deque = new ArrayDeque<>();
            dfs(0, len, res, deque, nums);
            return res;
        }

        public void dfs(int begin, int len, List<List<Integer>> res, Deque<Integer> deque, int[] nums) {
            res.add(new ArrayList<>(deque));
            for (int i = begin; i < len; i++) {
                deque.addLast(nums[i]);
                dfs(i + 1, len, res, deque, nums);
                deque.removeLast();
            }
        }
    }
}
