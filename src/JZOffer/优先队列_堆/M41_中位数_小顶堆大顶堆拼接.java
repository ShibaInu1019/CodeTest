package JZOffer.优先队列_堆;

import java.util.PriorityQueue;

/**
 * 小顶堆（存储大一半元素）----大顶堆（存储小一半元素）
 */
public class M41_中位数_小顶堆大顶堆拼接 {

    private PriorityQueue<Integer> a;
    private PriorityQueue<Integer> b;

    public M41_中位数_小顶堆大顶堆拼接() {
        //最小堆
        a = new PriorityQueue<>();
        //最大堆
        b = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (a.size() != b.size()) {
            a.add(num);
            b.add(a.poll());
        } else {
            b.add(num);
            a.add(b.poll());
        }
    }

    public double findMedian() {
        return (a.size() != b.size()) ? a.peek() : (a.peek() + b.peek()) / 2.0;
    }
}
