package LeetCode;

import java.util.LinkedList;

public class Offer59_queue {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums == null)
            return new int[0];
        //创建双端队列
        LinkedList<Integer> queue = new LinkedList<>();
        //构建res数组
        int res[] = new int[nums.length - k + 1];
        //循环numms
        for (int i = 0; i < nums.length; i++) {
            //当队尾元素小于当前元素  全部出队
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.pollLast();
            //入队nums下标
            queue.addLast(i);
            //如果队列长度为k，即队列满，队首出队
            if (queue.peek() <= i - k)
                queue.poll();
            //当形成窗口时，存储最大值
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[queue.peek()];
            }
        }
        return res;
    }
}
