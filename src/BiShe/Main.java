package BiShe;

import java.util.Scanner;

/**
 *
 * 网易笔试
 */
public class Main {

    public static int css(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                continue;
            } else {
                res += arr[i] >>> 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(css(arr));
    }


}
