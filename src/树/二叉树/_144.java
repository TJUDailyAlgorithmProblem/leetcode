package 树.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144 {
    class Solution {
        /*1.递归*/
//        List<Integer> ans = new ArrayList<>();
//
//        public List<Integer> preorderTraversal(TreeNode root) {
//            preorder(root);
//            return ans;
//        }
//
//        private void preorder(TreeNode node) {
//            if (node == null) return;
//            ans.add(node.val);
//            preorder(node.left);
//            preorder(node.right);
//        }
    }

    /*2.迭代写法*/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();/*关键code*/
            ans.add(top.val);
            if (top.right != null) {
                stack.push(top.right);/*top的左和右*/
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
        return ans;
    }
}
