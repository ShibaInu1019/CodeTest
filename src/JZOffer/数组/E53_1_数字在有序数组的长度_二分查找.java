package JZOffer.数组;

public class E53_1_数字在有序数组的长度_二分查找 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int a = ef(nums, target);
        int b = ef(nums, target + 1);
        return b - a;
    }

    private int ef(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] >= target)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
}
