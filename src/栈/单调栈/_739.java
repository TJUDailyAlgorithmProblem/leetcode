package 栈.单调栈;

import java.util.Stack;

/**
 * Description:
 *
 * @author zwill
 * @date 2021/9/30 11:27
 */
public class _739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && (temperatures[i] >= temperatures[stack.peek()])) {
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
