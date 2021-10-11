package 高级数据结构与算法作业._0926.homework;


import java.util.Scanner;

public class problemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[101];
        while (true) {
            int n = scanner.nextInt();
            if (n == 0)
                break;
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            mySort(a, n);
            for (int i = 0; i < n - 1; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println(a[n - 1]);
        }
    }

    public static void mySort(int[] a, int n) {
        int i, j;
        for (i = n - 1; i > 0; i--) {
            for (j = 1; j <= i; j++)
                if (Math.abs(a[j - 1]) < Math.abs(a[j])) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
        }
    }
}
