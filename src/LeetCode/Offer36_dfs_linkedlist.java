package LeetCode;

public class Offer36_dfs_linkedlist {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

    //创建指针
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        dfs(root);
        //维护循环链表的头结点和尾节点
        head.left = pre;
        pre.right = head;
        return head;
    }

    //中序遍历
    private void dfs(Node cur) {
        if (cur == null) return;
        //遍历左子树
        dfs(cur.left);
        //pre为cur左侧的节点，初始为null
        if (pre == null)
            //cur为头结点
            head = cur;
        else
            //存在pre即存在cur左侧节点
            pre.right = cur;
        cur.left = pre;
        //pre指向当前的cur,即向后跳跃
        pre = cur;
        //遍历右子树
        dfs(cur.right);
    }


}
