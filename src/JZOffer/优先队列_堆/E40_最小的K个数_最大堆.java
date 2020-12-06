package JZOffer.优先队列_堆;

import java.util.PriorityQueue;

/**
 * 最大堆存储最小的k个元素
 * 先存入k个元素，接下来添加的元素和堆顶比较，比堆顶小就添加
 */
public class E40_最小的K个数_最大堆 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || arr == null || k == 0)
            return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> (y - x));
        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (num < queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }

        int[] res = new int[queue.size()];
        int index = 0;
        for (Integer n : queue)
            res[index++] = n;
        return res;
    }
}
