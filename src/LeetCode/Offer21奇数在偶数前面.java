package LeetCode;

public class Offer21奇数在偶数前面 {


    public int[] exchange(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int temp;
        while (left < right) {
            //从左到右查找偶数
            while (left < right && (nums[left] % 2 != 0))
                left++;
            //从右到左查找奇数
            while (left < right && (nums[right] % 2 == 0))
                right--;
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
