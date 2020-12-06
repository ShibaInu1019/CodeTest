package BiShe.爱奇艺;

import java.util.Scanner;

public class Main {


    public static int CountZero2(int n) {
        int count = 0;
        if (n < 0)
            return -1;
        for (int i = 5; n / i > 0; i *= 5) {
            count += n / i;
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(CountZero2(n));
    }

}
