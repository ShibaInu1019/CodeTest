package Solution;

import java.util.ArrayList;
import java.util.List;

public class LinkedList234 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        //回文链表
        //放入list中进行回文校验
        //时间复杂度/空间复杂度 ---- O(n)
        List list = new ArrayList();

        ListNode cur = head;

        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
