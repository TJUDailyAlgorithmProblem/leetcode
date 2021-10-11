package 高级数据结构与算法作业._0926.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class problemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] str = s.split("[5]");
            int[] a = new int[1010];
            Arrays.fill(a, Integer.MAX_VALUE);
            int k = 0;
            for (String value : str) {
                if (!value.equals("")) {
                    a[k] = Integer.parseInt(value);
                    k++;
                }
            }
            mySort(a);
            for (int i = 0; i < k; i++) {
                if (i < k - 1)
                    System.out.print(a[i] + " ");
                else
                    System.out.println(a[i]);
            }
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
