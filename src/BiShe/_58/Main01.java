package BiShe._58;

import java.util.Scanner;

public class Main01 {

    static int k = 2;

    public static void fjzys(int n) {
        while (n >= k) {
            if (n == k) {
                System.out.println(n);
                break;
            } else if (n > k && n % k == 0) {
                System.out.println(k);
                n /= k;
                fjzys(n);
                break;
            } else if (n > k && n % k != n) {
                k++;
                fjzys(n);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fjzys(n);
    }
}
