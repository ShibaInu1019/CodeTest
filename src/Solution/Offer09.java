package Solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer09 {


    //双端队列
    class CQueue {
        Deque<Integer> stack1;
        Deque<Integer> stack2;
        int size;

        public CQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
            size = 0;
        }

        public void appendTail(int value) {
            stack1.add(value);
            size++;
        }

        public int deleteHead() {
            if (size == 0)
                return -1;
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }
            size--;
            return stack2.pop();
        }
    }
}
