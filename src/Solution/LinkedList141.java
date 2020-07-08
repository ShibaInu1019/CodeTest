package Solution;

public class LinkedList141 {
//给定一个链表，判断链表中是否有环。

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle_(ListNode head) {
        if (head == null)
            return false;
        //快指针在前，慢指针在后
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        //快慢指针
        //让快指针先跑
        // 如果是环形链表则会追上慢指针
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            //判断快指针是否到尾部
            // 由于快指针每次走两步，所以两种判断（链表中元素单数和双数）
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
