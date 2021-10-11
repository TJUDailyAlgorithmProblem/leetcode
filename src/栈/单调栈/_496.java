package 栈.单调栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * Description:
 *
 * @author zwill
 * @date 2021/10/5 14:58
 */
public class _496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                hashMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = hashMap.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
