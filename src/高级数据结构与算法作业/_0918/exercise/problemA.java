package 高级数据结构与算法作业._0918.exercise;

import java.util.Scanner;
import java.util.Stack;

public class problemA {
    final static int N = 1005;
    static int[] target = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            Stack<Integer> stack = new Stack<>();
            int index1 = 1; //原顺序
            int index2 = 1; //出栈序列位置
            for (int i = 1; i <= n; i++) {
                target[i] = scanner.nextInt();
            }
            int ok = 1;
            while (index2 <= n) {
                if (index1 == target[index2]) {
                    index1++;
                    index2++;
                } else if (!stack.isEmpty() && stack.peek() == target[index2]) {
                    stack.pop();
                    index2++;
                } else if (index1 <= n) {
                    stack.push(index1++);
                } else {
                    ok = 0;
                    break;
                }
            }
            System.out.println(ok == 1 ? "Yes" : "No");
        }
    }
}
