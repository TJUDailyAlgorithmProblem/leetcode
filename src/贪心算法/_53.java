package 贪心算法;

public class _53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int sum = Integer.MIN_VALUE;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count += nums[i];
                sum = Math.max(sum, count);
                if (count <= 0) {
                    count = 0;
                }
            }
            return sum;
        }
    }
}
