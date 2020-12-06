package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Offer54二叉搜索树第k大节点 {
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
        bst(root, list);
        //由于list索引是从0开始算的   k必定是大于等于1的
        return list.get(k - 1);
    }


    //中序遍历倒序
    //从大到小   放入list
    private void bst(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        bst(root.right, list);
        list.add(root.val);
        bst(root.left, list);
    }
}
