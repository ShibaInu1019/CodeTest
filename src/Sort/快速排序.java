package Sort;

import java.util.Arrays;

/**
 * 将数组划分为两部分，左部分小于中间值，右部分大于中间值；
 * 不稳定
 * 时间：O（nlogn），空间：O（nlogn）
 */
public class 快速排序 {

    public static void 快速排序(int[] array, int left, int right) {
        // 递归终止条件，起点索引大于等于终点索引
        if (left >= right) {
            return;
        }
        // 起点索引
        int i = left;
        // 终点索引
        int j = right;
        // 基准值
        int k = array[left];
        // 循环条件：起点索引小于终点索引
        while (i < j) {
            /*
            这个循环是要扫描小于基准值的值，扫描到后退出循环,
            循环条件：当前索引位的值大于等于基准值k(加等于号是防止相同数字交换而陷入死循环中),
            且起点索引小于终点索引(防止数组下标出界)
             */
            while (array[j] > k && i < j)
                // 终点索引位从右至左逐个递减
                j--;
            // 将小于基准值的数移至左侧
            array[i] = array[j];
            /*
            这个循环是要扫描大于基准值的值，扫描到后退出循环,
            循环条件：当前索引位的值小于等于基准值k(加等于号是防止相同数字交换而陷入死循环中),
            且起点索引小于终点索引(防止数组下标出界)
             */
            while (array[i] < k && i < j)
                // 起点索引位从左至右逐个递增
                i++;
            // 将大于基准值的数移至右侧
            array[j] = array[i];
        }
        // 基准值归位（数组的中间某个位置），归位后，基准值左侧都是小于基准值的数，右侧都是大于基准值的数
        array[j] = k;
        // 递归将基准值左侧的数排序
        快速排序(array, left, j - 1);
        // 递归将基准值右侧的数排序
        快速排序(array, j + 1, right);
    }


    static int split(int[] array, int left, int right) {
        // 以当前范围数组的第一个值作为中线
        int temp = array[left];
        while (left < right) {
            // 右指针出现了一个数比中线小，则与中线进行交换
            while (left < right && temp < array[right]) right--;
            array[left] = array[right];
            // 左指针出现了一个数比中线大，则与中线进行交换
            while (left < right && temp > array[left]) left++;
            array[right] = array[left];
        }
        // 此时left == right，并无所谓是谁来进行交换
        array[left] = temp;
        return left;
    }

    public static void main(String[] args) {
        int[] demo = new int[]{1, 5, 3, 8, -2, 9};
        快速排序(demo, 0, demo.length - 1);
        System.out.println(Arrays.toString(demo));
    }
}
