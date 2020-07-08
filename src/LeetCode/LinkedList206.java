package LeetCode;

public class LinkedList206 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;//创建一个空指针
        ListNode cur = head;

        while (cur != null) {
            //next记录下一个节点
            ListNode next = cur.next;
            //当前节点指向前一个节点
            cur.next = prev;
            //prev指向cur
            prev = cur;
            //error: 这里如果写cur=cur.next,cur会为null，退出循环
            //cur指向next
            cur = next;
        }
        //返回最后一个节点prev，此时cur为null
        return prev;
    }

}
