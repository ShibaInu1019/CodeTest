package LeetCode;

import java.util.PriorityQueue;

public class Offer41 {

    private PriorityQueue<Integer> A;
    private PriorityQueue<Integer> B;

    public Offer41() {
        //优先队列（默认从小到大）
        A = new PriorityQueue<>();
        //优先队列从大到小
        B = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
