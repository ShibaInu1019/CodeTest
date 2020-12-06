package JZOffer.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 */
public class M37_序列化二叉树_BFS {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null,");
            }
        }
        //最后会多一个","
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[index]));
                queue.add(node.left);
            }
            index++;
            if (!vals[index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[index]));
                queue.add(node.right);
            }
            index++;
        }
        return root;
    }
}
