package JZOffer.树;

import java.util.HashMap;
import java.util.logging.Level;

/**
 * 用前序和中序递归出整个二叉树
 * 前序的第一个节点是root，然后在中序中拆分成左右子树
 * 在根据前序中的左右子树的根节点，再次拆分，以此类推
 */
public class M07_重建二叉树_递归 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] qianxu;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.qianxu = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //递归 前序遍历的根节点  中序遍历的左边界  中序遍历右边界
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int root, int l, int r) {
        if (l > r) return null;
        //拿到前序遍历中的root
        TreeNode rootNode = new TreeNode(qianxu[root]);
        //获取root在中序遍历中的索引
        int i = map.get(qianxu[root]);
        //左子树根节点：当前root+1；左边界：l；右边界：i-1；
        rootNode.left = recur(root + 1, l, i - 1);
        //右子树根节点 = 当前根节点+左子树长度（左子树右边界-左子树左边界+1）；
        rootNode.right = recur(root + 1 + (i - 1 - l + 1), i + 1, r);
        return rootNode;
    }
}
