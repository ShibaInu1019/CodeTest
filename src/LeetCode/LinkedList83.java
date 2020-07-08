package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LinkedList83 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        //由于不用删除第一个节点，无需设置虚拟头结点
        ListNode cur = head;
        //需要判断当前节点的下一个节点是否为null
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }


    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        List list = new ArrayList();

        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newlinked = new ListNode(0);

        ListNode prev = newlinked;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newlinked.next = l1;
                l1 = l1.next;
            } else {
                newlinked.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        newlinked.next = l1 != null ? l1 : l2;
        return newlinked.next;
    }
}
