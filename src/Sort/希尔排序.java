package Sort;

import java.util.Arrays;

/**
 * 先对数组元素两两分组（同组的两个元素相隔半个数组长度），然后每个组使用插入排序；
 * 再缩小分组跨度，进行插入排序...，直到最后一次分组跨度为1，执行一次插入排序即可
 * 不稳定
 * 时间：低于O（n^2），最差O（n^2），空间：O（1）
 */
public class 希尔排序 {
    public static int[] 希尔排序(int[] array) {
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j = i - gap;
                while (j >= 0 && array[j] > temp) {
                    array[j + gap] = array[j];
                    j = j - gap;
                }
                array[j + gap] = temp;
            }
            gap = gap / 2;
        }
        return array;
    }

    public static void sort(int[] array) {
        //希尔排序的增量
        int d = array.length;
        while (d > 1) {
            //使用希尔增量的方式，即每次折半
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i = i + d) {
                    int temp = array[i];
                    int j;
                    for (j = i - d; j >= 0 && array[j] > temp; j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] demo = new int[]{1, 5, 3, 8, -2, 9};
        System.out.println(Arrays.toString(希尔排序.希尔排序(demo)));
    }
}
