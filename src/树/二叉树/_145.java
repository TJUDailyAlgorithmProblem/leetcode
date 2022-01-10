package 树.二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _145 {
    class Solution {
        List<Integer> ans = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            postorder(root);
            return ans;
        }

        private void postorder(TreeNode node) {
            if (node == null) return;
            postorder(node.left);
            postorder(node.right);
            ans.add(node.val);
        }
    }

    /*2.迭代*/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
