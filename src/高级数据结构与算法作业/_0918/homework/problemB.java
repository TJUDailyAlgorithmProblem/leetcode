package 高级数据结构与算法作业._0918.homework;


import java.util.Scanner;

public class problemB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] tmp = new char[1005];
        int n = scanner.nextInt();
        while (n-- != 0) {
            char[] inputString = scanner.next().toCharArray();
            int res = 0;
            int top = -1;
            for (int i = 0; i < inputString.length; i++) {
                if (top == -1 && inputString[i] == ')') {
                    if (tmp[top] == '(') {
                        top--;
                        res++;
                    } else {
                        tmp[++top] = ')';
                    }
                } else {
                    tmp[++top] = inputString[i];
                }
            }
            System.out.println(res);
        }
    }
}
