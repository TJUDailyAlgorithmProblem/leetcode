package 栈.单调栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * Description:
 *
 * @author zwill
 * @date 2021/10/5 19:45
 */
public class _503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}
