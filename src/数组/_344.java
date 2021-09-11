package 数组;

public class _344 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            left++;
            right--;
        }
    }
}
