package LeetCode;

public class Offer27二叉树镜像 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //二叉树镜像
    //左节点变右节点，右节点变左节点
    //root节点不变
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
