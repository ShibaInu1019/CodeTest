package QuickSort;

import java.util.Arrays;

public class QuickSort {

    //填坑
    public static void Quick_Sort(int[] nums, int left, int right) {

        if (left > right)
            return;
        //定义nums[left]为基准
        int x = nums[left];
        int i = left;
        int j = right;

        while (i < j) {
            //从右往左查找比x小的数
            while (i < j && nums[j] > x)
                j--;
            //进入if的条件是nums[j]<x
            //填nums[i]的坑，之后nums[j]就会空出来
            nums[i] = nums[j];

            //从左往右查找比x大的数
            while (i < j && nums[i] < x)
                i++;
            //进入if的条件是nums[i]>=x
            //填nums[j]的坑，之后nums[i]就会空出来
            nums[j] = nums[i];
        }
        //最后再将最初的基准x放入nums[i]
        nums[i] = x;
        //递归左边部分
        Quick_Sort(nums, left, i - 1);
        //递归右边部分
        Quick_Sort(nums, i + 1, right);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 12, 8, 6, 7};
        Quick_Sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
