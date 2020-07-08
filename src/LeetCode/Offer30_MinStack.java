package LeetCode;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
public class Offer30_MinStack {


    class Node {
        private int val;
        private int min;
        private Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    class MinStack {

        /**
         * initialize your data structure here.
         */

        private Node head;

        public MinStack() {

        }

        //入栈
        public void push(int x) {
            if (head == null)
                head = new Node(x, x, null);
            else
                //类似于入栈，将新元素放在链表头
                head = new Node(x, Math.min(x, head.min), head);
        }

        //出栈（链表头）
        public void pop() {
            //head后移
            head = head.next;
        }

        //链表head即栈顶元素
        public int top() {
            return head.val;
        }

        //获取最小值
        public int min() {
            return head.min;
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */

}
