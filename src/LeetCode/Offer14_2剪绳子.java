package LeetCode;

public class Offer14_2剪绳子 {

    public int cuttingRope(int n) {
        if (n <= 3)
            return n - 1;
        int mod = (int) (1e9 + 7);
        long res = 1;
        while (n > 4) {
            res = res * 3;
            res = res % mod;
            n = n - 3;
        }
        return (int) (res * n % mod);
    }

}
