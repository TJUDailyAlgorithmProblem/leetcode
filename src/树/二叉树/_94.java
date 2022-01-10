package 树.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94 {
    class Solution {
        /*1.递归写法*/
        List<Integer> ans = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            inorder(root);
            return ans;
        }

        private void inorder(TreeNode node) {
            if (node == null) return;
            inorder(node.left);
            ans.add(node.val);
            inorder(node.right);
        }
    }

    /*2.迭代写法*/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
        }
        return ans;
    }
}
