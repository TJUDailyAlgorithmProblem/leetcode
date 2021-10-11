package 栈.单调栈;


import java.util.Stack;

public class _42 {
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && (height[stack.peek()] < height[i])) {
                int curr = stack.peek();
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int right = i;
                int h = Math.min(height[left], height[right]) - height[curr];
                res += (right - left - 1) * h;
            }
            stack.push(i);
        }
        return res;
    }
}
