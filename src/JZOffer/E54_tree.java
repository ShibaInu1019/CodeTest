package JZOffer;

import java.util.ArrayList;
import java.util.List;

public class E54_tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthLargest(TreeNode root, int k) {
        if (root == null)
            return 0;
        List<Integer> list = new ArrayList<>();
        //中序遍历为升序
        //题目要求为降序
        bst(root, list);
        //返回中序遍历中第k-1个节点
        //list下标从0开始
        return list.get(k - 1);
    }

    //中序遍历（逆序）
    private void bst(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        bst(root.right, list);
        //添加val
        list.add(root.val);
        bst(root.left, list);
    }

}
