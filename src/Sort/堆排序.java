package Sort;

import java.util.Arrays;

/**
 * 构建大顶堆，存入元素；
 * 每次拿出堆顶元素，填入顺序从数组尾至数组首；
 * 时间：O（nlogn），空间：O（1）
 * 不稳定
 */
public class 堆排序 {

    public static int[] 堆排序(int[] array) {
        if (array.length == 0 || array == null)
            return null;
        int len = array.length;
        //构建大顶堆
        buildMaxHeap(array, len);
        for (int i = len - 1; i > 0; i--) {
            swap(array, 0, i);
            len--;
            heapify(array, 0, len);
        }
        return array;
    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] demo = new int[]{1, 5, 3, 8, -2, 9};
        System.out.println(Arrays.toString(堆排序.堆排序(demo)));
    }
}
