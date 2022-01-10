package 回溯法;

import java.util.*;

public class _90 {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            if (len == 0) return res;
            Deque<Integer> deque = new ArrayDeque<>(len);
            Arrays.sort(nums);
            boolean[] used = new boolean[len];
            dfs(0, len, res, deque, nums, used);
            return res;
        }

        public void dfs(int begin, int len, List<List<Integer>> res, Deque<Integer> deque, int[] nums, boolean[] used) {
            res.add(new ArrayList<>(deque));
            for (int i = begin; i < len; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                deque.addLast(nums[i]);
                used[i] = true;
                dfs(i + 1, len, res, deque, nums, used);
                deque.removeLast();
                used[i] = false;
            }
        }
    }
}
