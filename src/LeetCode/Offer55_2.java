package LeetCode;

public class Offer55_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        //1.左右子树高度差<=1
        //2.左子树是平衡二叉树
        //3.右子树是平衡二叉树
        return (Math.abs(maxDepth(root.right) - maxDepth(root.left)) <= 1) && isBalanced(root.left) && isBalanced(root.right);

    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
