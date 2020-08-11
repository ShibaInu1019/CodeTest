package JZOffer.链表;

/**
 * c为公共段
 * a+c+b = b+c+a;
 */
public class E52_相交链表 {


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
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }
}
