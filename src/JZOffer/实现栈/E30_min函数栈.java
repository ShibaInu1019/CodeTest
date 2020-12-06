package JZOffer.实现栈;

/**
 * 用一个倒序的链表来模拟栈
 * 节点Node中设置min
 */
public class E30_min函数栈 {

    class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    /**
     * initialize your data structure here.
     */
    public E30_min函数栈() {

    }

    public void push(int x) {
        if (head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int min() {
        return head.min;
    }
}
