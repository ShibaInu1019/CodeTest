package LeetCode;

public class Tree938 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        //递归终止条件
        if (root == null)
            return 0;
        if (root.val < L)
            return rangeSumBST(root.right, L, R);
        else if (root.val > R)
            return rangeSumBST(root.left, L, R);
        //返回值
        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);

    }
}
