package LeetCode;

import java.util.*;

public class Tree102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        //创建返回的结果res
        List<List<Integer>> res = new ArrayList<>();
        //创建队列存储每一层的节点
        Deque<TreeNode> queue = new ArrayDeque<>();
        //加入root节点
        queue.add(root);


        //如果队列不为空
        while (queue.size() > 0) {
            //获取队列中节点数量
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            //每一层进行出队，然后入队下一层
            for (int i = 0; i < size; i++) {
                //记录出队节点
                TreeNode node = queue.remove();
                //加入temp
                temp.add(node.val);
                //左子树不为空入队
                if (node.left != null) {
                    queue.add(node.left);
                }
                //右子树不为空入队
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //添加进res
            res.add(temp);
        }
        return res;
    }
}
