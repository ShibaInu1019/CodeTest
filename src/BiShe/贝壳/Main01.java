package BiShe.贝壳;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main01 {

    public static int huo(int[] arr) {
        if (arr.length == 0 || arr == null)
            return 0;
        int[][] a = new int[arr.length + 1][arr.length + 1];
        for (int i = 1; i < arr.length + 1; i++) {
            a[0][i] = arr[i - 1];
            a[i][0] = arr[i - 1];
        }
        int max = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < arr.length + 1; j++) {
                a[i][j] = a[i][0] | a[0][j];
                if (a[i][j] > max) {
                    max = a[i][j];
                    res = Math.abs(j - i) + 1;
                } else if (a[i][j] == max) {
                    if (Math.abs(j - i) + 1 < res)
                        res = Math.abs(j - i) + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(huo(arr));
    }
}
