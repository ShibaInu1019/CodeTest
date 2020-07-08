package Solution;

import java.math.BigDecimal;

public class LinkedList1290 {
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
