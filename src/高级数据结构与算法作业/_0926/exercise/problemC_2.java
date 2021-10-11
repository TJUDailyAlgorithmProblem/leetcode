package 高级数据结构与算法作业._0926.exercise;


import java.util.Scanner;

public class problemC_2 {

    private static long count = 0;

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int lines = sc.nextInt();
            int[] array = new int[lines];
            int[] array1 = new int[lines];
            if (lines == 0)
                break;
            else {
                for (int i = 0; i < lines; i++) {
                    array[i] = sc.nextInt();
                }
                mergeSort(array, 0, array.length - 1, array1);
                System.out.println(count);
            }
        }
    }

    private static void mergeSort(int[] array, int begin, int end, int[] array1) {
        int[] array2 = new int[end + 1];
        if (begin == end) {
            array1[begin] = array[begin];
        } else {
            int mid = (begin + end) / 2;
            mergeSort(array, begin, mid, array2);
            mergeSort(array, mid + 1, end, array2);
            merge(array2, begin, mid, end, array1);
        }
    }

    private static void merge(int[] array2, int begin, int mid, int end, int[] array1) {
        int i = begin;
        int j = mid + 1;
        int k = begin;
        while (i <= mid && j <= end) {
            if (array2[i] < array2[j]) {
                array1[k++] = array2[i++];
            } else {
                array1[k++] = array2[j++];
                count += mid - i + 1; //左边没比完的元素和右边这个元素构成逆序对。
            }
        }
        while (i <= mid) {
            array1[k++] = array2[i++];
        }
        while (j <= end) {
            array1[k++] = array2[j++];
        }
    }
}

