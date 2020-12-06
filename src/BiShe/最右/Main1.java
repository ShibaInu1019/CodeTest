package BiShe.最右;

import java.util.Scanner;

public class Main1 {


    public static int tree(int n) {
        if (n < 1)
            return 0;
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] = arr[i] + arr[j] * arr[i - 1 - j];
            }
        }
        return arr[n];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(tree(num));
    }
}
