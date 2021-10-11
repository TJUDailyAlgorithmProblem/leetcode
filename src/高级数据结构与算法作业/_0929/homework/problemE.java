package 高级数据结构与算法作业._0929.homework;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Description:
 *
 * @author zwill
 * @date 2021/9/30 19:43
 */
public class problemE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        while (cases-- != 0) {
            int len1 = scanner.nextInt();
            int len2 = scanner.nextInt();
            Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
            for (int i = 0; i < len1 + len2; i++) {
                queue.add(scanner.nextInt());
            }
            for (int len = 0; len < len1 + len2; len++) {
                if (len != len1 + len2 - 1) {
                    System.out.print(queue.poll() + " ");
                } else {
                    System.out.println(queue.poll());
                }
            }
        }
    }
}
