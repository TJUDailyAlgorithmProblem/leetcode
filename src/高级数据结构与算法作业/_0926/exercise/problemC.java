package 高级数据结构与算法作业._0926.exercise;

import java.util.*;

public class problemC {
    static int[] arr;

    // 交换数组中的两个元素
    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 一般归并排序写两个函数，我懒得写，感觉合成一个也挺好嘛
    static long compute(int l, int r) {
        // 递归结束条件不要忘记了哦
        if (r - l <= 1) {
            if (arr[r] < arr[l]) {
                swap(l, r);
                return 1;
            } else {
                return 0;
            }
        }
        int mid = (l + r) / 2;
        // result = 两个数都位于前半部分时，逆序对数量d1 + 两个数都位于后半部分时，逆序对数量d2 +
        // 第一个数字位于前半部分，第二个数字位于后半部分时，逆序对数量count

        // 分治分治，先分后治
        long d1 = compute(l, mid);
        long d2 = compute(mid + 1, r);
        // 前半部分长度
        int len1 = mid - l + 1;
        // 后半部分长度
        int len2 = r - mid;
        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];

        // 把两个部分的数组拿出来，等会儿要用
        for (int i = 0; i < len1; i++) {
            arr1[i] = arr[l + i];
        }

        for (int j = 0; j < len2; j++) {
            arr2[j] = arr[mid + 1 + j];
        }

        // 计算第一个数字位于前半部分，第二个数字位于后半部分时，逆序对数量
        int i = 0, j = 0, k = l;
        // count是结果，必须定义成long，否则WA
        long count = 0;
        // 归并过程
        while (i < len1 && j < len2) {
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
                // 归并过程中，如果前面某个元素大于后面某个元素，说明前面的剩余元素都大于后面的这个元素
                // 所以把前面部分的剩余元素数量给加上
                count += len1 - i;
            }
        }
        if (i >= len1 && j < len2) {
            while (j < len2) {
                arr[k++] = arr2[j++];
            }
        }
        if (j >= len2 && i < len1) {
            while (i < len1) {
                arr[k++] = arr1[i++];
            }
        }
        return count + d1 + d2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != 0) {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            long result = compute(0, n - 1);
            System.out.println(result);
            n = sc.nextInt();
        }
    }
}
