package 高级数据结构与算法作业._0926.exercise;


import java.util.Scanner;

public class problemB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
            }
            mySort(a);
            System.out.println(a[a.length / 2]);
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
