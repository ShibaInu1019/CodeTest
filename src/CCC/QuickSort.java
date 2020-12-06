package CCC;


public class QuickSort {

    public int[] sortArray(int[] nums) {
        qSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void qSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int k = part(nums, left, right);
        qSort(nums, left, k - 1);
        qSort(nums, k + 1, right);
    }


    public int part(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && temp <= nums[right]) right--;
            nums[left] = nums[right];
            while (left < right && temp >= nums[left]) left++;
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }
}
