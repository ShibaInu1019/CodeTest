package BiShe;

import java.util.*;

/**
 * 神州数码笔试
 */
public class Test04_0727 {

    static class TreeNode {
        TreeNode left = null;
        TreeNode right = null;
        int value;

        TreeNode(int v) {
            this.value = v;
        }
    }

    public int Height(TreeNode root) {
        if (root == null)
            return 0;
        int left = 0;
        int right = 0;
        if (root.left != null)
            left = Height(root.left);
        if (root.right != null)
            right = Height(root.right);
        return ((left >= right) ? left : right) + 1;
    }

    public static void main(String[] args) {
        Test04_0727 m = new Test04_0727();
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int rootVal = s.nextInt();
        int rootFirst = s.nextInt();
        TreeNode root = new TreeNode(rootVal);
        TreeNode rootLeft = new TreeNode(rootFirst);
        root.left = rootLeft;
        HashMap<Integer, TreeNode> nodeMap = new HashMap<>();
        nodeMap.put(rootVal, root);
        nodeMap.put(rootFirst, rootLeft);
        for (int i = 0; i < num - 2; i++) {
            int parentVal = s.nextInt();
            int childVal = s.nextInt();
            TreeNode parent = nodeMap.get(parentVal);
            TreeNode child = new TreeNode(childVal);
            if (parent != null) {
                if (parent.left == null) {
                    parent.left = child;
                } else if (parent.right == null) {
                    parent.right = child;
                }
            } else {
                parent = new TreeNode(parentVal);
                parent.left = child;
            }
            nodeMap.put(parentVal, parent);
            nodeMap.put(childVal, child);
        }
        System.out.println(m.Height(root));
        s.close();
    }
}
