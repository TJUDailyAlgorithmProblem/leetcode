package 链表;

public class _206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode preNode = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = tmp;
        }
        return preNode;
    }

    /*前序遍历*/
    public static void reverseListDFS1(ListNode head) {
        if (head == null) return;
        ListNode pre = null;
        ListNode tmp = head.next;
        head.next = pre;
        reverseListDFS1(tmp);
    }

    /*todo 难！后序遍历*/
    public ListNode reverseListDFS2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = reverseListDFS2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
