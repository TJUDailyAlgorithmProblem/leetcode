package 高级数据结构与算法作业._0918.homework;


import java.util.*;

public class problemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int m = scanner.nextInt();
        while (m-- != 0) {
            int n = scanner.nextInt();
            scanner.nextLine();
            Queue<String> queue = new LinkedList<>();
            Stack<String> stack = new Stack<>();
            while (n-- != 0) {
                String line = scanner.nextLine();
                if (line.charAt(1) == 'u') {
                    queue.add(line.split(" ")[1]);
                    stack.push(line.split(" ")[1]);
                } else {
                    if (queue.isEmpty() || stack.isEmpty()) {
                        System.out.println("error");
                    } else {
                        queue.poll();
                        stack.pop();
                    }
                }
            }
            if (queue.isEmpty() || stack.isEmpty()) {
                System.out.println("error");
            } else {
                for (int i = 0; i < queue.size() - 1; i++) {
                    System.out.print(queue.poll() + " ");
                }
                System.out.println(queue.poll());
                int len = 0;
                for (String s : stack) {
                    if (len == stack.size() - 1) {
                        System.out.println(s);
                    } else {
                        System.out.print(s + " ");
                        len++;
                    }
                }
            }
        }
    }
}
