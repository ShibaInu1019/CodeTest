package JZOffer;

import javax.xml.soap.Node;

public class E18_linkedlist {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return null;
        //设置虚拟头结点
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        //指针pre
        ListNode pre = dummyhead;
        while (pre.next != null) {
            //找到要删除的val
            if (pre.next.val == val)
                //跳过删除的val=删除val
                pre.next = pre.next.next;
            else
                //pre后移
                pre = pre.next;
        }
        return dummyhead.next;
    }
}
