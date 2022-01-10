package 贪心算法;

import java.util.*;

public class _406 {
    static class Solution {
        public static int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return b[0] - a[0];
            });
            LinkedList<int[]> que = new LinkedList<>();
            for (int[] p : people) {
                que.add(p[1], p);
            }
            return que.toArray(new int[people.length][]);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[4];
        int[][] arr2 = new int[4][4];
        Arrays.fill(arr1, 1);
        for (int[] value : arr2) {
            Arrays.fill(value, 1);
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println("============");
        for (int[] ints : arr2) {
            System.out.println(Arrays.toString(ints));
        }
        int[] arr3 = new int[]{1, 2, 3, 4};
        int[] arr4 = new int[]{1, 2, 3, 4};
        int[] arr5 = new int[]{1, 2, 3, 5};
        System.out.println("============");
        System.out.println("arr3和arr4是否相等?" + Arrays.equals(arr3, arr4));
        System.out.println("arr3和arr5是否相等?" + Arrays.equals(arr3, arr5));
        System.out.println("============");
        String[] arr6 = {"aa", "bb", "cc"};
        Integer[] arr7 = {1, 2, 3, 5};
        List<String> list1 = Arrays.asList(arr6);
        List<Integer> list2 = Arrays.asList(arr7);
        //list1.add("c");
        String[] arr8 = {"a", "b", "c"};
        List<String> list3 = new ArrayList<>(Arrays.asList(arr8));
        list3.add("d");
        System.out.println(list3);
        System.out.println("============");
        String[] arr9 = {"a1", "b1", "c1"};
        String[] arr10 = Arrays.copyOf(arr9, arr9.length);
        String[] arr11 = Arrays.copyOfRange(arr9, 0, 1);
        System.out.println(Arrays.toString(arr10));
        System.out.println(Arrays.toString(arr11));
        System.out.println("============");
        Integer[] arr12 = {11, 22, 33, -55, 44};
        String[] arr13 = {"aa", "Bc", "dd", "AA", "cc"};
        Arrays.sort(arr12, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Arrays.sort(arr13);
        System.out.println(Arrays.toString(arr12));
        System.out.println(Arrays.toString(arr13));
        System.out.println("============");
        int[] arr14 = new int[]{1, 2, 2, 4, 5, 6};
        System.out.println(Arrays.binarySearch(arr14, 2));
    }
}
