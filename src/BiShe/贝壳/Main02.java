package BiShe.贝壳;

import java.util.Scanner;

public class Main02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            if (N == 1)
                System.out.println(getMin(M));
            else if (M == 1)
                System.out.println(getMin(N));
            else {
                int min = Math.min(getMin(N), getMin(M));
                System.out.println(min);
            }
        }
    }

    private static int getMin(int n) {
        for (int i = 2; i <= Math.pow(n, 0.5); i++) {
            if (n % i == 0)
                return i;
        }
        return n;
    }
}
