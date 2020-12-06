package LeetCode;

public class LinkedList1290二进制链表转整数 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;

        }
    }

    public int getDecimalValue(ListNode head) {
        int res = 0;

        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }
        return res;
    }

}
