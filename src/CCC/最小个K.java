package CCC;

import java.util.PriorityQueue;

public class 最小个K {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0)
            return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> (y - x));

        for (int num : arr) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() > num) {
                queue.poll();
                queue.add(num);
            }
        }
        int index = 0;
        int[] res = new int[queue.size()];
        for (Integer q : queue) {
            res[index++] = q;
        }
        return res;
    }


    public int findKth(int[] a, int n, int K) {
        // write code here
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer num : a) {
            queue.add(num);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
