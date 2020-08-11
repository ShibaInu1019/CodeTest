package JZOffer.链表;


/**
 * 链表倒数的第K个节点
 * 快慢指针
 */
public class E22_倒数第K_快慢指针 {

    public class ListNode {
        private ListNode next;
        private int val;

        ListNode(int x) {
            val = x;
        }

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = new ListNode(0);
        ListNode fast = new ListNode(0);

        slow = head;
        fast = head;
        //fast先走k个节点
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        //fast走到尾部，slow走到倒数第K个
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    public ListNode getKthFromEnd_(ListNode head, int k) {
        ListNode fast;
        ListNode slow;
        fast = head;
        slow = head;

        //fast 先走K个节点
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // fast 和 slow一起走到尾，slow走了总长度-K个节点
        // slow 指向倒数第K个节点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
