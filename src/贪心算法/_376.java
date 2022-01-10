package 贪心算法;

public class _376 {
    class Solution {
        /*贪心*/
        public int wiggleMaxLength(int[] nums) {
            int ans = 1;
            int curDiff = 0;
            int preDiff = 0;
            for (int i = 1; i < nums.length; i++) {
                curDiff = nums[i] - nums[i - 1];
                if (curDiff > 0 && preDiff <= 0 || curDiff < 0 && preDiff >= 0) {
                    ans++;
                    preDiff = curDiff;
                }
            }
            return ans;
        }

        /*动态规划*/
        public int wiggleMaxLength2(int[] nums) {
            int down = 1, up = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1])
                    up = down + 1;
                else if (nums[i] < nums[i - 1])
                    down = up + 1;
            }
            return nums.length == 0 ? 0 : Math.max(down, up);
        }
    }
}
