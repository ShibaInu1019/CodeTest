package JZOffer.链表;

/**
 * 从尾到头打印链表输出数组
 * 先计算链表长度，在创建一个数组，对数组从后向前赋值链表的节点
 */
public class E06_反转链表返回数组 {

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
        //再次初始化cur
        cur = head;
        //res倒序赋值
        //索引i = count -1才是数组最后一个元素，第一个元素的索引i=0
        for (int i = count - 1; i >= 0; i--) {
            res[i] = cur.val;
            cur = cur.next;
        }
        return res;
    }

}
