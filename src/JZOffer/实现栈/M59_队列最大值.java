package JZOffer.实现栈;


import java.util.LinkedList;

public class M59_队列最大值 {

    LinkedList<Integer> queue, help;

    public M59_队列最大值() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    //max
    public int max_value() {
        if (help.isEmpty()) return -1;
        return help.peek();
    }

    //入队
    public void push_back(int value) {
        //主队列正常入队
        queue.offer(value);
        //辅助队列尾部清除比自己更小的元素
        while (!help.isEmpty() && value > help.peekLast())
            help.pollLast();
        help.offer(value);
    }

    //出队
    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        //主队列正常出队
        int val = queue.poll();
        //查看辅助队列max是否和出队元素相同，相同则出队
        if (help.peek() == val)
            help.pop();
        return val;
    }
}
