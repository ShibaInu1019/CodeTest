package JZOffer.链表;

public class M35_复杂链表复制 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node cur = head;
            //1. 创建新的节点，连接到旧链表中
            //  1->2->3     --------     1->1'->2->2'->3->3'
            while (cur != null) {
                Node newNode = new Node(cur.val);
                newNode.next = cur.next;
                cur.next = newNode;
                cur = newNode.next;
            }
            //2. 初始化新节点的random指针
            cur = head;
            while (cur != null) {
                //初始化random指针
                cur.next.random = (cur.random != null) ? cur.random.next : null;
                cur = cur.next.next;
            }

            //3. 将新链表拆出来
            cur = head;
            Node newNode = head.next;
            while (cur.next != null) {
                Node temp = cur.next;
                cur.next = cur.next.next;
                cur = temp;
            }
            return newNode;
        }

    }
}