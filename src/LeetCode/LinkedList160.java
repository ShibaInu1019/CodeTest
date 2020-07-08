package LeetCode;

public class LinkedList160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //设链表A的长度为a+c，链表B的长度为b+c，a为链表A不公共部分，b为链表B不公共部分，c为链表A、B的公共部分
    //将两个链表连起来，A->B和B->A，长度：a+c+b+c=b+c+a+c
    //若链表AB相交，则a+c+b与b+c+a就会抵消，它们就会在c处相遇；
    //若链表AB不相交，则c为null，则a+b=b+a，它们各自移动到尾部循环结束，即返回null
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;


        while (nodeA != nodeB) {
            if (nodeA != null)
                nodeA = nodeA.next;
            else
                nodeA = headB;

            if (nodeB != null)
                nodeB = nodeB.next;
            else
                nodeB = headA;
        }
        return nodeA;
    }
}
