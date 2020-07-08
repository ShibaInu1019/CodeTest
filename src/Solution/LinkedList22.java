package Solution;

public class LinkedList22 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = new ListNode(0);
        ListNode fast = new ListNode(0);

        slow = head;
        fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode slow = dummyhead;
        ListNode fast = dummyhead;

        //快指针先走n+1步（n+1是因为有虚拟头结点）
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        //fast会走到null
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //指向下下一个节点
        slow.next = slow.next.next;
        //返回链表头结点
        return dummyhead.next;
    }
}

