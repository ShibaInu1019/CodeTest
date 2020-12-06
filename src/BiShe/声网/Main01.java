package BiShe.声网;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        one(n);
    }

    public static void one(int n) {
        if (n <= 0 || n >= 10000 || n % 2 == 0 || n % 5 == 0)
            return;
        long m = 1;
        for (int i = 0; i < n; i++) {
            if (m % n == 0) {
                String s = String.valueOf(m);
                System.out.println(s.length());
            } else {
                m = (long) (m + Math.pow(10, i + 1));
            }
        }
    }
}
