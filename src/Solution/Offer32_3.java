package Solution;

import java.util.*;
import java.util.concurrent.DelayQueue;

public class Offer32_3 {
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
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = deque.poll();
                if (res.size() % 2 == 0)
                    //偶数从右向左
                    list.addLast(temp.val);
                else
                    //奇数从左向右
                    list.addFirst(temp.val);

                if (temp.left != null)
                    deque.add(temp.left);
                if (temp.right != null)
                    deque.add(temp.right);
            }
            res.add(list);
        }
        return res;
    }
}
