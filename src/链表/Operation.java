package 链表;

import org.junit.Test;

public class Operation {
    //数组遍历
    @Test
    public void test1() {
        int[] arr = new int[]{1, 2, 3};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //链表的遍历
    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.println((cur.val));
        }
    }

    /*数组转置*/
    @Test
    public void test3() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int tmp = arr[right];
            arr[right] = arr[left];
            arr[left] = tmp;
            left++;
            right--;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
