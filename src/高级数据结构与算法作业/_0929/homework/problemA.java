package 高级数据结构与算法作业._0929.homework;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Description:
 *
 * @author zwill
 * @date 2021/9/30 18:49
 */
public class problemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        Queue<Integer> queue = new PriorityQueue<>();
        while (n-- != 0) {
            String[] line = scanner.nextLine().split(" ");
            if (line[0].equals("I")) {
                if (queue.size() < k) {
                    queue.add(Integer.valueOf(line[1]));
                } else if (Integer.parseInt(line[1]) > queue.peek()) {
                    queue.add(Integer.valueOf(line[1]));
                    queue.poll();
                }
            } else {
                System.out.println(queue.peek());
            }
        }
    }
}
