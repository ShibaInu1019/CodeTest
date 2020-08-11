package JZOffer.树;

public class E28_镜像对称_递归 {

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
        return recur(root.left, root.right);

    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return false;
        if (left == null || right == null || right.val != left.val)
            return false;
        return recur(left.left, left.right) && recur(right.left, right.right);
    }
}
