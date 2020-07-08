package LeetCode;

public class LinkedList0202 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        //先让快指针走k步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        //将快慢指针一起走到尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
