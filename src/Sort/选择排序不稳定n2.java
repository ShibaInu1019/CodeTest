package Sort;

import java.util.Arrays;

/**
 * 内层循环每轮找到最小的元素索引，
 * 外层循环将最小元素和数组首的元素互换，相当于将最小元素移动到数组首
 * 非稳定
 * 时间：O（n^2），空间：O（1）
 */
public class 选择排序不稳定n2 {

    public static int[] 选择排序(int[] array) {
        if (array.length == 0 || array == null)
            return null;
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] demo = new int[]{1, 5, 3, 8, -2, 9};
        System.out.println(Arrays.toString(选择排序不稳定n2.选择排序(demo)));
    }
}
