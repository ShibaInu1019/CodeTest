package Solution;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;

public class Tree0402 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0 || nums == null)
            return null;
        //二分搜索树的root节点应该是nums数组的中间值
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        //递归左子树
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        //递归右子树
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        return root;
    }

    public static void main(String[] args) {

        int[] original = new int[]{1, 2, 3, 4, 5, 6};

        int[] a = Arrays.copyOfRange(original, 1, 4);
        System.out.println("参数to小于original.length:" + Arrays.toString(a));

        int[] b = Arrays.copyOfRange(original, 1, 8);
        System.out.println("参数to大于original.length（超出部分用0补齐）:" + Arrays.toString(b));
    }
}
