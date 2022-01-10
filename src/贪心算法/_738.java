package 贪心算法;

public class _738 {
    class Solution {
        public int monotoneIncreasingDigits(int n) {
            StringBuilder ans = new StringBuilder();
            char[] num = (n + "").toCharArray();
            int[] arr = new int[num.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = num[i] - '0';
            }
            for (int i = arr.length - 1; i > 0; i--) {
                if (arr[i - 1] > arr[i]) {
                    arr[i - 1]--;
                    for (int j = i; j < arr.length; j++) {
                        arr[j] = 9;
                    }
                }
            }
            for (int j : arr) {
                ans.append(j);
            }
            return Integer.parseInt(ans.toString());
        }
    }
}
