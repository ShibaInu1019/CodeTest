package BiShe;


import LeetCode.Offer32;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 奇安信笔试
 */
public class Test_0801 {

    public static void main(String[] args) {
        Test_0801 rs = new Test_0801();
        System.out.println(rs.reletive_7(new int[]{1, 1, 2}));
    }

    private ArrayList<Integer> list = new ArrayList<>();
    private boolean[] used;

    public int reletive_7(int[] digit) {
        // write code here
        int length = digit.length, res = 0;
        used = new boolean[length];
        for (int i = 0; i < length; i++) {
            dfs(digit, i, length, 1, 0);
        }
        for (int i : list) {
            if (i % 7 == 0) {
                res++;
            }
        }
        return res;
    }

    private void dfs(int[] digit, int i, int length, int now, int number) {
        used[i] = true;
        number = number * 10 + digit[i];
        if (now == length) {
            list.add(number);
            used[i] = false;
            return;
        }
        for (int j = 0; j < length; j++) {
            if (!used[j]) {
                dfs(digit, j, length, now + 1, number);
            }
        }
        used[i] = false;
    }


    public static class Money {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int all = sc.nextInt();
            int n = sc.nextInt();
            int[] w = new int[n];
            int[] v = new int[n];
            int[][] dp = new int[n + 1][all + 1];
            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
                v[i] = sc.nextInt();
            }
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < all + 1; j++) {
                    if (j >= w[i - 1]) {
                        dp[i][j] = Math.max(dp[i - 1][j - w[i - 1]] + v[i - 1], dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            System.out.println(dp[n][all]);
        }

    }
}
