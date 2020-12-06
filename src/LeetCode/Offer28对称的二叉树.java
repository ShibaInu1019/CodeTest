package LeetCode;

public class Offer28对称的二叉树 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        //递归左右子树
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        //同时为空
        if (left == null && right == null)
            return true;
        //不同时为空 或者 左右子树不等
        if (left == null || right == null || left.val != right.val)
            return false;
        //递归左子树与右子树
        return recur(left.left, right.right) && recur(left.right, right.left);
    }

}
