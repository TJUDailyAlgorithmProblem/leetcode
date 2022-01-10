package 回溯法;


import java.util.*;

public class _47 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums==null||nums.length==0) return res;
            boolean[] used = new boolean[nums.length];
            Deque<Integer> deque  = new ArrayDeque<>(nums.length);
            int depth = 0;
            Arrays.sort(nums);
            dfs(nums.length,depth,nums,used,res,deque);
            return res;
        }
        public void dfs(int len, int depth, int[] nums, boolean[] used, List<List<Integer>> res,Deque<Integer> deque){
            if (len==depth){
                res.add(new ArrayList<>(deque));
                return;
            }
            for (int i = 0; i < len; i++) {
                if(i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                    continue;
                }
                if (!used[i]){
                    used[i] = true;
                    deque.addLast(nums[i]);
                    dfs(len,depth+1,nums,used,res,deque);
                    used[i] = false;
                    deque.removeLast();
                }
            }
        }
    }
}
