package LeetCode;

public class Tree530 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    TreeNode tree = null;
    int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        if (root == null)
            return 0;
        bst(root);
        return res;
    }

    //中序遍历,找到相邻节点最小差值
    private void bst(TreeNode root) {
        if (root == null)
            return;
        bst(root.left);
        if (tree != null) {
            //root.val - tree.val即当前节点和上一个根节点的差值
            res = Math.min(res, root.val - tree.val);
        }
        tree = root;
        bst(root.right);
    }

}
