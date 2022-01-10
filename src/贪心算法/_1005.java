package 贪心算法;

import java.util.Arrays;

public class _1005 {
    static class Solution {
        public static int largestSumAfterKNegations(int[] nums, int k) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (k == 0) {
                    return Arrays.stream(nums).sum();
                }
                if (nums[i] <= 0) {
                    nums[i] = -nums[i];
                    k--;
                } else {
                    break;
                }
            }
            if (k % 2 == 0 || Arrays.binarySearch(nums, 0) != -1) {
                return Arrays.stream(nums).sum();
            } else {
                Arrays.sort(nums);
                return Arrays.stream(nums).sum() - 2 * nums[0];
            }
        }

        public static void main(String[] args) {
            largestSumAfterKNegations(new int[]{-4,-6,9,-2,2}, 4);
        }
    }
}
