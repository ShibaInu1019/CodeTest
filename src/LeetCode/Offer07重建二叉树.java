package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Offer07重建二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    Map<Integer, Integer> map = new HashMap<>();
    int[] preo;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //存储前序遍历
        preo = preorder;
        //存储中序遍历的节点和索引关系
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //开启递归
        return recur(0, 0, inorder.length - 1);
    }

    //root_index 是根节点在前序遍历中的索引
    //left_index 是中序遍历中的左边界
    //right_index 是中序遍历中的右边界
    private TreeNode recur(int root_index, int left_index, int right_index) {
        if (left_index > right_index)
            return null;
        //根节点是前序遍历的首个节点
        TreeNode root = new TreeNode(preo[root_index]);
        //index是根节点在中序遍历中的索引
        int index = map.get(preo[root_index]);

        //左子树的根节点是前序遍历的根节点的下一个节点
        root.left = recur(root_index + 1, left_index, index - 1);

        //右子树的根节点是根节点索引index+左子树长度+1
        //左子树长度 = 右边界 - 左边界 = index-1 - left_index + 1
        root.right = recur(root_index + (index - 1 - left_index + 1) + 1, index + 1, right_index);

        return root;
    }
}
