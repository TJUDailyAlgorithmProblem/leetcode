package 回溯法;

import java.util.*;

public class _39 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates.length==0) return new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            int sum = 0;
            Arrays.sort(candidates);
            Deque<Integer> deque = new ArrayDeque<>(candidates.length);
            dfs(candidates,0,target,sum,deque,res);
            return res;
        }
        
        public void dfs(int[] candidates, int begin,int target,int sum,Deque<Integer> deque,List<List<Integer>> res){
            if (target==sum){
                res.add(new ArrayList<>(deque));
                return;
            }
            for (int i = begin; i < candidates.length; i++) {
                if (sum>target) return;
                deque.addLast(candidates[i]);
                dfs(candidates, i,target,sum+candidates[i],deque,res);
                deque.removeLast();
            }
        }
    }
}
