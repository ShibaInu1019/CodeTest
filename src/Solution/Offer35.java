package Solution;

public class Offer35 {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    ;

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node cur = head;
        //复制新节点并连接
        while (cur != null) {
            Node newnode = new Node(cur.val);
            newnode.next = cur.next;
            cur.next = newnode;
            cur = newnode.next;
        }

        //完成random节点指向
        cur = head;
        while (cur != null) {
            cur.next.random = (cur.random != null) ? cur.random.next : null;
            cur = cur.next.next;
        }

        //分离 新/旧 链表
        cur = head;
        Node newcur = head.next;
        while (cur.next != null) {
            Node temp = cur.next;
            cur.next = cur.next.next;
            cur = temp;
        }
        return newcur;
    }
}
