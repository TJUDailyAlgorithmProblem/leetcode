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
}
