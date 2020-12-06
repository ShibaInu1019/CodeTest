package BiShe.应太来;

import java.math.BigInteger;
import java.util.Scanner;

public class Main01 {


    public static void main(String[] args) {
        BigInteger[][] dp = new BigInteger[50][50];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new BigInteger(Integer.toString(i));
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = new BigInteger(Integer.toString(i));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j].add(dp[i][j - 1]).add(new BigInteger("2"));
            }
        }
        StringBuilder sb = new StringBuilder();
        int N = n, M = m;
        long K = k;
        while (K > 0) {
            if (N > 0 && M > 0) {
                if (dp[N - 1][M].compareTo(new BigInteger(Long.toString(K - 1))) >= 0) {
                    K--;
                    sb.append('a');
                    N--;
                } else {
                    K -= dp[N - 1][M].longValue() + 2;
                    sb.append('b');
                    M--;
                }
            } else if (N > 0 && M == 0) {
                K--;
                sb.append('a');
                N--;
            } else if (N == 0 && M > 0) {
                K--;
                sb.append('b');
                M--;
            } else {
                K = 0;
            }
        }
        System.out.println(sb.toString());
    }
}
