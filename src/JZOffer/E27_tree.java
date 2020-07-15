package JZOffer;

public class E27_tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        //存储左子树
        TreeNode temp = root.left;
        //递归右子树
        root.left = mirrorTree(root.right);
        //递归左子树
        root.right = mirrorTree(temp);
        return root;
    }
}
