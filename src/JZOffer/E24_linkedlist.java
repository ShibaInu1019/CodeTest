package JZOffer;

public class E24_linkedlist {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {

        //定义null节点
        ListNode pre = null;
        //cur指针
        ListNode cur = head;
        while (cur != null) {
            //存储下一个节点
            ListNode next = cur.next;
            //cur指向前一个节点
            cur.next = pre;
            //pre后移
            pre = cur;
            //cur后移
            cur = next;
        }
        //返回pre，也就是链表最后一个节点
        return pre;
    }

}
