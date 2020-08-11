package JZOffer.树;

public class E68_树最近公共祖先_递归 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        // 当p和q中出现root时，root就是最近公共祖先
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //pq在右子树
        if (left == null)
            return right;
        //pq在左子树
        if (right == null)
            return left;
        //pq一个在左，一个在右
        return root;
    }
}
