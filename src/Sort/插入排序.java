package Sort;

import java.util.Arrays;

/**
 * 从第一元素开始插入操作，从后向前插入查找插入位置，完成插入（类似于扑克牌）
 * 稳定
 * 时间：O（n^2），空间：O（1）
 */
public class 插入排序 {

    public static int[] 插入排序(int[] array) {
        if (array.length == 0 || array == null)
            return null;
        //从下标为1的元素开始插入，默认第一个元素（下标为0）是有序的
        for (int i = 1; i < array.length; i++) {
            //记录要插入的元素
            int temp = array[i];
            //存储本次要判断元素的索引
            int j = i;
            //从后向前查找对应的插入位置
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            //插入
            array[j] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] demo = new int[]{1, 5, 3, 8, -2, 9};
        System.out.println(Arrays.toString(插入排序.插入排序(demo)));
    }
}
