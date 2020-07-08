package LeetCode;

public class LinkedList0203 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //删除当前节点实际是删除了下一个节点
    //但是将下一个节点值赋给了当前节点
    //删除后的链表结构与删除当前节点后的链表无异
    public void deleteNode(ListNode node) {
        //将node.next节点的值赋值给node节点
        node.val = node.next.val;
        //将node.next指向node的下下一个节点
        node.next = node.next.next;
    }
}
