package 高级数据结构与算法作业._0926.homework;


import java.util.Scanner;

public class problemD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        quickSort(t);
        for (int i = 0; i < n; i++) {
            if (sum > t[i])
                count++;
            else sum += t[i];
        }
        System.out.println(n - count);
    }

    public static void quickSort(int[] array) {
        int len;
        if (array == null || (len = array.length) == 0 || len == 1) {
            return;
        }
        sort(array, 0, len - 1);
    }

    public static void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            while (array[j] >= base && i < j) {
                j--;
            }
            while (array[i] <= base && i < j) {
                i++;
            }
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        array[left] = array[i];
        array[i] = base;
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }
}
