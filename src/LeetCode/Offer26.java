package LeetCode;

public class Offer26 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    //判断以a为根节点的树是否包含树b
    private boolean recur(TreeNode a, TreeNode b) {
        if (b == null)
            return true;
        if (a == null || a.val != b.val)
            return false;
        return recur(a.left, b.left) && recur(a.right, b.right);
    }
}
