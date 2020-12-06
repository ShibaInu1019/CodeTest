package LeetCode;

import java.util.Arrays;

public class Array88合并有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] one = {1, 2, 3, 0, 0, 0, 0};
        int[] two = {4, 5, 6, 7};

        //将数组two中元素从索引0开始长度为4,复制到数组one中从索引3开始
        System.arraycopy(two, 0, one, 3, 4);
        System.out.println("数组one为：" + Arrays.toString(one));

        //数组one现在为[1, 2, 3, 4, 5, 6, 7]
        //将数组one中的索引从0开始长度为3，复制到数组one的索引从4开始
        System.arraycopy(one, 0, one, 4, 3);
        System.out.println("数组one为：" + Arrays.toString(one));
    }
}
