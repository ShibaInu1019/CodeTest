package BiShe._360;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(max(arr));
    }

    private static int max(int[][] arr) {
        if (arr[0].length > 100 || arr.length > 100 || arr.length == 0 || arr == null)
            return 0;
        int m = arr.length;
        int n = arr[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = arr[i][j++] + arr[i + 1][j];
                if (temp > max)
                    max = temp;
            }
        }
        return max;
    }
}
