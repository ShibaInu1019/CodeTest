package JZOffer.树;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class M34_树的路径_回溯 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return new ArrayList<>();
        recur(root, sum);
        return res;
    }

    private void recur(TreeNode root, int tar) {
        if (root == null)
            return;
        list.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList<>(list));
        recur(root.left, tar);
        recur(root.right, tar);
        //回溯
        list.removeLast();
    }
}

