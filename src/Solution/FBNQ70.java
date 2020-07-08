package Solution;

public class FBNQ70 {

    //爬楼梯
    //可以选择每次上1个台阶或2个台阶

    //爬上第n个台阶需要
    // 在n-1上再上1个台阶  或者  在n-2上再上2个台阶
    //即 f(n) = f(n-1)+f(n-2)   相当于斐波那契数列
    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int thrid = first + second;
            first = second;
            second = thrid;
        }
        return second;
    }
}
