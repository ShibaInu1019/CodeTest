package Solution;

public class Offer57 {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0 || nums == null)
            return null;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target)
                right--;
            if (sum < target)
                left++;
            else
                return new int[]{nums[left], nums[right]};
        }
        return null;
    }
}
