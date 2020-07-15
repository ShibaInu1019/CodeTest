package JZOffer;

public class E22_linkedlist {

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
}
