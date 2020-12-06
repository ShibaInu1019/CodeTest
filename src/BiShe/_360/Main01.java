package BiShe._360;

import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {
        int m, n;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        if (n % 2 == 0) {
            while (true) ;
        }
        int a = 1, b = 2;
        boolean flag = true;
        int x;
        while (m-- > 0) {
            x = sc.nextInt();
            if (x == 1) {
                if (flag)
                    a += 2;
                else
                    b += 2;
            }
            flag = !flag;
        }
        for (int i = 1; i <= n; i++) {
            if (i != 1)
                System.out.println(" ");
        }
    }
}
