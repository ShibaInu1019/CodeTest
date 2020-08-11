package Sort;

import java.util.Arrays;

/**
 * 每两个元素进行比较，将大的元素向后移动，每次内层循环会将一个最大的元素移动到数组尾部
 * 稳定
 * 时间：O（n^2），空间：O（1）
 */
public class 冒泡排序 {

    public static int[] 冒泡排序(int[] array) {
        if (array.length == 0 || array == null)
            return null;
        //-1是为了防止数组越界
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] demo = new int[]{1, 5, 3, 8, -2, 9};
        System.out.println(Arrays.toString(冒泡排序.冒泡排序(demo)));
    }
}
