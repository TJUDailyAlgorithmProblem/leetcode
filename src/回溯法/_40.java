package 回溯法;

import java.util.*;

public class _40 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (candidates.length==0) return res;
            boolean[] used = new boolean[candidates.length];
            Arrays.sort(candidates);
            Deque<Integer> deque = new ArrayDeque<>(candidates.length);
            dfs(candidates,0,target,0,deque,res,used);
            return res;
        }
        public void dfs(int[] candidates,int begin,int target,int sum,Deque<Integer> deque,List<List<Integer>> res,boolean[] used){
            if (target==sum){
                res.add(new ArrayList<>(deque));
                return;
            }
            for (int i = begin; i < candidates.length; i++) {
                if (sum > target) return;
                if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                    continue;
                }
                if (!used[i]) {
                    deque.addLast(candidates[i]);
                    used[i] = true;
                    dfs(candidates, i,target, sum + candidates[i], deque, res, used);
                    deque.removeLast();
                    used[i] = false;
                }
            }
        }
    }
}
