package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer59_2 {
    private Deque<Integer> queue;
    private Deque<Integer> help;


    public Offer59_2() {
        queue = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : help.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!help.isEmpty() && value > help.peekLast()) {
            help.pollLast();
        }
        help.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        int val = queue.pop();
        if (help.peek() == val)
            help.pop();
        return val;
    }
}
