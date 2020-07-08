package Solution;

public class LinkedList21 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode prev = newNode;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        //合并后 l1 和 l2 最多只有一个最大的元素还未被合并
        //添加给新的链表
        prev.next = l1 == null ? l2 : l1;

        //返回合并后的链表
        return newNode.next;
    }

}
