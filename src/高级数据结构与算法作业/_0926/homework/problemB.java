package 高级数据结构与算法作业._0926.homework;


import java.util.Arrays;
import java.util.Scanner;

public class problemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[1005];
        Arrays.fill(a, Integer.MAX_VALUE);
        int n = scanner.nextInt();
        while (n-- != 0) {
            int len = scanner.nextInt();
            for (int i = 0; i < len; i++) {
                a[i] = scanner.nextInt();
            }
            mySort(a);
            System.out.print(a[0]);
            for (int i = 1; i < len; i++) {
                System.out.print(" " + a[i]);
            }
            System.out.println();
        }
    }

    public static void mySort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int temp = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[temp] > a[j]) {
                    temp = j;
                }
            }
            if (temp != i) {
                a[temp] = a[temp] ^ a[i];
                a[i] = a[temp] ^ a[i];
                a[temp] = a[temp] ^ a[i];
            }
        }
    }
}
