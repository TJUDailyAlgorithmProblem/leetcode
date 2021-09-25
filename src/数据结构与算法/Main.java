package 数据结构与算法;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        int n = scanner.nextInt();
        while (n-- != 0) {
            char[] inputString = scanner.next().toCharArray();
            int res = 0;
            for (int i = 0; i < inputString.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(inputString[i]);
                } else {
                    char tmp = stack.peek();
                    if (tmp == '(' && inputString[i] == ')') {
                        stack.pop();
                        res++;
                    } else {
                        stack.push(inputString[i]);
                    }
                }
            }
            System.out.println(res);
        }
    }
}
