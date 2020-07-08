package LeetCode;

public class Array7 {

    public int reverse(int x) {

        int res = 0;

        while (x != 0) {

            int pop = x % 10;
            x = x / 10;
            //res * 10 有可能会溢出 [−2^31,  2^31 − 1]
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            res = res * 10 + pop;
        }
        return res;
    }
}
