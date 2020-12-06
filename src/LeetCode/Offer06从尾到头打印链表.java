package LeetCode;

public class Offer06从尾到头打印链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {

        //计算链表容量
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        //定义数组
        //数组倒序赋值
        int[] res = new int[count];
        cur = head;
        for (int i = count - 1; i >= 0; i--) {
            res[i] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}
