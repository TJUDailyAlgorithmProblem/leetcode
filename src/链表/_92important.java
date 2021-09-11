package 链表;

public class _92important {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = null;
        ListNode pre = dummyNode;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        cur = pre.next;
        for (int i = left; i < right; i++) {
            ListNode tmp = cur.next;
            cur.next = cur.next.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummyNode.next;
    }
}
