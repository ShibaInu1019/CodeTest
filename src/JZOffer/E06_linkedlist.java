package JZOffer;

public class E06_linkedlist {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int count = 0;
        //计算链表容量
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        //创建res数组
        int res[] = new int[count];
        //初始化cur
        cur = head;
        //res倒序赋值
        for (int i = count - 1; i >= 0; i--) {
            res[i] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}
