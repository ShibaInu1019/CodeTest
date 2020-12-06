package BiShe.多益;

import java.util.Scanner;

public class Main {

    static int k = 2;

    public static void fjzys(int n) {
        while (n >= k) {
            if (n == k) {
                System.out.print(n);
                break;
            } else if (n > k && n % k == 0) {
                System.out.print(k + "*");
                n /= k;
                fjzys(n);
                break;
            } else if (n > k && n % k != 0) {
                k++;
                fjzys(n);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(n + "=");
        fjzys(n);
    }
}
