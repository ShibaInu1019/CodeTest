package Sort;

import java.util.Arrays;

/**
 * 先拆分成两半，再继续拆分直到变成单个元素，相邻的两个元素再按照大小排序合并,然后2+2，4+4....
 * 时间：O（nlogn），空间：O（n）
 * 稳定
 */
public class 归并排序稳定nlogn {

    public static void 归并排序(int[] array, int left, int right) {
        if (array.length == 0 || array == null || left == right)
            return;
        int mid = (left + right) >>> 1;
        归并排序(array, left, mid);
        归并排序(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int a = left;
        int b = mid + 1;
        while (a <= mid && b <= right) {
            temp[i++] = array[a] < array[b] ? array[a++] : array[b++];
        }
        while (a <= mid) {
            temp[i++] = array[a++];
        }
        while (b <= right) {
            temp[i++] = array[b++];
        }
        for (i = 0; i < temp.length; i++) {
            array[left + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] demo = new int[]{1, 5, 3, 8, -2, 9};
        归并排序(demo, 0, demo.length - 1);
        System.out.println(Arrays.toString(demo));
    }
}
