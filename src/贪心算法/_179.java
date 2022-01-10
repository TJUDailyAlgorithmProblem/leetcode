package 贪心算法;

import java.util.Arrays;

public class _179 {
    class Solution {
        public String largestNumber(int[] nums) {
            int n = nums.length;
            String numsToWord[] = new String[n];
            for (int i = 0; i < n; i++) {
                numsToWord[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(numsToWord, (a, b) -> {
                return (b + a).compareTo(a + b);
            });
            if (numsToWord[0].equals("0")) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(numsToWord[i]);
            }
            return sb.toString();
        }
    }
}
