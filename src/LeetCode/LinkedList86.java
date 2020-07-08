package LeetCode;

public class LinkedList86 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //分隔链表
    //小于x的节点用one链表来连接，大于等于x的节点用two来连接
    //最后连接one与two两个链表
    public ListNode partition(ListNode head, int x) {

        ListNode one = new ListNode(0);
        ListNode one_prev = one;
        ListNode two = new ListNode(0);
        ListNode two_prev = two;


        while (head != null) {
            if (head.val < x) {
                one_prev.next = head;
                one_prev = one_prev.next;
            } else {
                two_prev.next = head;
                two_prev = two_prev.next;
            }
            head = head.next;
        }
        two_prev.next = null;

        one_prev.next = two.next;
        return one.next;
    }
}
