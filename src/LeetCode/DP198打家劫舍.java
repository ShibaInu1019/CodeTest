package LeetCode;

public class DP198打家劫舍 {
    //f(k) = max( f(k-2) + Ak, f(k) )
    //定义f(-1) = f(0) = 0 简化计算

    public int rob(int[] nums) {
        //f(-1) = 0;
        int pre = 0;
        //f(0) = 0;
        int cur = 0;

        for (int num : nums) {
            //存储之前的最大值
            int temp = cur;
            //计算新的最大值
            cur = Math.max(pre + num, cur);
            //之前的最大值 变为 下一轮的pre
            pre = temp;
        }
        return cur;
    }

}
