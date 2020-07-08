package LeetCode;

public class Offer53_1 {

    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null)
            return 0;
        int a = search2(nums, target);
        int b = search2(nums, target + 1);
        return b - a;
    }

    private int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + right >>> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


}
