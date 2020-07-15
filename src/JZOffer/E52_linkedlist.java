package JZOffer;

public class E52_linkedlist {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        //指针
        ListNode a = headA;
        ListNode b = headB;

        //如果ab不相交
        while (a != b) {
            if (a != null)
                a = a.next;
            else
                a = headB;
            if (b != null)
                b = b.next;
            else
                b = headA;
        }
        return a;
    }
}
