package 回溯法;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;

public class _46 {
    public static class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null||nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        Deque<Integer> deque  = new ArrayDeque<>(nums.length);
        int depth = 0;
        dfs(nums.length,depth,nums,used,res,deque);
        return res;
    }

    public void dfs(int len, int depth, int[] nums, boolean[] used, List<List<Integer>> res,Deque<Integer> deque){
        if (len==depth){
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < len; i++) {
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
