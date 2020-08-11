package JZOffer.树;

public class E68_1_搜索树最近公共祖先 {
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
        while (root != null) {
            if (p.val > root.val && q.val > root.val)
                root = root.right;
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            else
                break;
        }
        return root;
    }
}
