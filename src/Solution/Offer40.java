package Solution;

import java.util.Arrays;

public class Offer40 {

    public int[] getLeastNumbers(int[] arr, int k) {

        if (arr.length == 0 || arr == null)
            return null;
        optimize(arr, 0, arr.length - 1, k);
        //返回数组的前k个数
        return Arrays.copyOfRange(arr, 0, k);
    }

    //优化   使用快排划分数组
    //只需要找到前k个元素  并不需要确定顺序
    public void optimize(int[] arr, int left, int right, int k) {
        int m = Quick_Sort(arr, left, right);
        if (m == k)
            return;
        else if (m > k)
            //最小的k个数是在快排的左边
            optimize(arr, left, m - 1, k);
        else
            optimize(arr, m + 1, right, k);
    }


    //快排
    public int Quick_Sort(int[] nums, int left, int right) {

        if (left > right)
            return 0;
        //定义nums[left]为基准
        int x = nums[left];
        int i = left;
        int j = right;

        while (i < j) {
            //从右往左查找比x小的数
            while (i < j && nums[j] >= x)
                j--;
            //进入if的条件是nums[j]<x
            if (i < j) {
                //填nums[i]的坑，之后nums[j]就会空出来
                nums[i] = nums[j];
                i++;
            }

            //从左往右查找比x大的数
            while (i < j && nums[i] < x)
                i++;
            //进入if的条件是nums[i]>=x
            if (i < j) {
                //填nums[j]的坑，之后nums[i]就会空出来
                nums[j] = nums[i];
                j--;
            }
        }
        //最后再将最初的基准x放入nums[i]
        return x;
    }
}
