package JZOffer.数组;

public class E53_2_缺失的数字_二分 {

    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] == m)
                l = m + 1;
            else
                r = m - 1;
        }
        return l;
    }
}
