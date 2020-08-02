package LeetCode;

public class Offer16 {
    public static double myPow(double x, int n) {
        if (x == 0)
            return 0;
        //存储long是为了防止  pow = -pow越界
        long pow = n;
        double res = 1;
        //如果指数是负数，底数变倒数，指数变正数
        if (pow < 0) {
            x = 1 / x;
            pow = -pow;
        }
        //如果指数是正数
        while (pow > 0) {
            //pow & 1 相当于 pow % 2
            //pow = 1 计算 res
            if ((pow & 1) == 1)
                res = res * x;
            x = x * x;
            // 1/2 = 0
            pow = pow >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Offer16.myPow(3,5));
    }
}
