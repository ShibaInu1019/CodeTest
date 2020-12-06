package BiShe.去哪儿;

import java.util.Scanner;

public class Main {

    public static long cmn(int m, int n) {
        if (n>=100)
            return 0;
        if (m > n)
            return 0;
        if (m > n / 2)
            m = n - m;
        return fac(m, n) / fac(m, m);

    }

    private static long fac(int m, int n) {
        long sum = 1;
        while (n > 0 && m > 0) {
            sum = sum * n--;
            m--;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(cmn(n, m));
    }
}
