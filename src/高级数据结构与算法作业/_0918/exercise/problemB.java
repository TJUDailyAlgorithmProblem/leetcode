package 高级数据结构与算法作业._0918.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;


public class problemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt(); //情况
        int num; //存的数
        String mode, operation;
        while (cases-- != 0) {
            int n = scanner.nextInt(); //操作次数
            mode = scanner.next();
            if (mode.equals("FIFO")) { //队列
                ArrayDeque<Integer> queue = new ArrayDeque<>(n);
                for (int i = 0; i < n; i++) {
                    operation = scanner.next();
                    if (operation.charAt(0) == 'I') {//入
                        num = scanner.nextInt();
                        queue.addLast(num);
                    } else {  //出
                        if (queue.isEmpty()) {
                            System.out.println("None");
                        } else {
                            System.out.println(queue.pop());
                        }
                    }
                }
            } else {  //栈
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < n; i++) {
                    operation = scanner.next();
                    if (operation.charAt(0) == 'I') {//入
                        num = scanner.nextInt();
                        stack.add(num);
                    } else {  //出
                        if (stack.isEmpty()) {
                            System.out.println("None");
                        } else {
                            System.out.println(stack.pop());
                        }
                    }
                }
            }
        }
    }
}
