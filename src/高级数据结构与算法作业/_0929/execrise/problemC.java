package 高级数据结构与算法作业._0929.execrise;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class problemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int[] a = new int[30];
        String s;
        while (true) {
            Arrays.fill(a, 0);
            s = scanner.next();
            if (s.equals("END")) {
                break;
            }
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '_') {
                    a[26]++;
                } else {
                    a[s.charAt(i) - 'A']++;
                }
            }
            Queue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i <= 26; i++) {
                if (a[i] != 0) {
                    queue.add(a[i]);
                }
            }
            int sum = 0;
            while (queue.size() > 1) {
                int x = queue.poll();
                int y = queue.poll();
                queue.add(x + y);
                sum += (x + y);
            }
            if (sum == 0) {
                sum = len;
            }
            System.out.printf("%d %d %.1f\n", len * 8, sum, (len * 8.0) / (sum * 1.0));
            queue.clear();
        }
    }
}