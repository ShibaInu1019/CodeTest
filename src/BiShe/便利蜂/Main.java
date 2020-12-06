package BiShe.便利蜂;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        String str = sc.next();
        String[] strings = str.split(",");
        int[] items = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            items[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(new Main().buy(money, items));
    }


    public int buy(int money, int[] items) {

        int[][] dp = new int[items.length][money + 1];
        for (int i = 0; i < items.length - 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < money; j++) {
            if (j % items[0] == 0) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < items.length; i++) {
            for (int j = 1; j <= money; j++) {
                int temp = 0;
                for (int k = 0; k * items[i] <= j; k++) {
                    temp += dp[i - 1][j - k * items[i]];
                }
                dp[i][j] = temp;
            }
        }
        return dp[items.length - 1][money];
    }
}
