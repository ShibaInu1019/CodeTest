package Solution;

public class Offer68 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //迭代效率要高于递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        while (root != null) {
            if (p.val > root.val && q.val > root.val)
                root = root.right;
            else if (p.val < root.val && q.val < root.val)
                root = root.left;
            else
                break;
        }
        return root;
    }


    //二叉搜索树最近公共祖先
    //递归
    public TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor_(root.right, p, q);
        else if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor_(root.left, p, q);
        return root;
    }
}
