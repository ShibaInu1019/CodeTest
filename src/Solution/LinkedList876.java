package Solution;

import java.util.HashSet;
import java.util.List;

public class LinkedList876 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //不涉及头结点删除，无需设置虚拟头结点
        ListNode cur = head;

        HashSet set = new HashSet();
        set.add(cur.val);
        while (cur.next != null) {
            //判断下一个元素是否重复
            if (set.contains(cur.next.val))
                //重复则跳过
                cur.next = cur.next.next;
            else {
                //不重复则添加
                set.add(cur.next.val);
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }

}