package JZOffer.链表;

public class M148_链表排序_归并排序 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        //快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        //慢指针走一步，快指针走两步
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时慢指针走到了中间
        //存储后一半链表 temp
        ListNode temp = slow.next;
        //切分链表
        slow.next = null;
        //递归左链表和右链表
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        //创建一个节点  用来合并两个链表
        ListNode h = new ListNode(0);
        //存储合并链表的头结点
        ListNode res = h;
        //进行合并
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        //剩余元素添加
        h.next = left != null ? left : right;
        return res.next;
    }

}
