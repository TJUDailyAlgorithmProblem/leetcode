package 高级数据结构与算法作业._0929.execrise;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class problemA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            Queue<Integer> queue = new PriorityQueue<Integer>();
            for (int i = 0; i < n; i++) {
                queue.add(in.nextInt());
            }
            long cost = 0;
            while (queue.size() > 1) {
                int c1 = queue.poll();
                int c2 = queue.poll();
                cost += c1 + c2;
                queue.add(c1 + c2);
            }
            System.out.println(cost);
        }
    }
}
