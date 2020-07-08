package LeetCode;

import java.util.LinkedList;

public class SlidingWindow239 {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null && nums.length == 0)
            return nums;

        //双端队列来存储当前窗口最大值的数组索引
        //保证队列中数组索引对应的值从大到小
        LinkedList<Integer> queue = new LinkedList<>();


        //存储结果数组
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            //判断队列尾元素是否小于当前元素
            // 如果小于当前元素出队
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.pollLast();


            //入队当前元素的索引
            //为什么队列中要存放数组下标的值而不是直接存储数值？
            // 因为要判断队首的索引是否在窗口范围内，由数组下标取值很方便，而由值取数组下标不是很方便
            queue.addLast(i);

            //判断队列首是否在窗口内
            //如果不在窗口内   则弹出队首
            if (queue.peek() <= i - k)
                queue.poll();

            //当形成窗口时，存储最大元素
            //只有当nums索引为i+1时才会形成窗口
            if (i + 1 >= k)
                //下标i+1-k对应从0开始赋值
                res[i + 1 - k] = nums[queue.peek()];
        }
        return res;
    }
}
