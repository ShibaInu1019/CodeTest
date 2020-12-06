package LeetCode;

public class Offer14_1剪绳子 {
    /**
     * 1.只要把 n 尽可能的拆分成包含3的组合，就可以得到最大值。
     * 2.如果没办法拆成 3 的组合，就退一步拆成 2 的组合。
     * 3.对于 3 和 2 ，没办法再进行拆分。
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        //n最小是2
        if (n <= 3)
            return n - 1;
        int x = n / 3, y = n % 3;
        //整除属于情况1，直接返回3的x次方
        if (y == 0) return (int) Math.pow(3, x);
        //余数为1属于情况2，相当于余数是4=2*2组合，返回3的x-1次方*2*2
        if (y == 1) return (int) Math.pow(3, x - 1) * 4;
        //余数是2属于情况3，直接返回3和2的组合
        return (int) (Math.pow(3, x) * 2);
    }

    public int cuttingRope_(int n) {
        if (n <= 3)
            return n - 1;
        int res = 1;
        while (n > 4) {
            res = res * 3;
            n = n - 3;
        }
        return res * n;
    }
}
