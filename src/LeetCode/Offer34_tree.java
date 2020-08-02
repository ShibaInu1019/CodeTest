package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class Offer34_tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //存储结果
    LinkedList<List<Integer>> res = new LinkedList<>();
    //存储路径
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    //回溯
    private void recur(TreeNode root, int tar) {
        if (root == null)
            return;
        //加入更节点
        path.add(root.val);
        //计算剩下路径总和
        tar -= root.val;
        //路径和符合条件，并且是叶子节点
        if (tar == 0 && root.left == null && root.right == null)
            //相当于存储路径的快照，如果后续进行回溯就会影响path，从而影响res
            res.add(new LinkedList<>(path));
        recur(root.left, tar);
        recur(root.right, tar);
        //回溯，删除不符合的节点值
        path.removeLast();
    }
}
