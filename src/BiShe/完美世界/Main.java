package BiShe.完美世界;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int knapsackCapacity = Integer.parseInt(input.nextLine().trim());

        String[] volumesStr = input.nextLine().split(" ");
        int[] volumes = new int[volumesStr.length];
        for (int i = 0; i < volumesStr.length; i++) {
            volumes[i] = Integer.parseInt(volumesStr[i].trim());
        }

        String[] valuesStr = input.nextLine().split(" ");
        int[] values = new int[valuesStr.length];
        for (int i = 0; i < valuesStr.length; i++) {
            values[i] = Integer.parseInt(valuesStr[i].trim());
        }

        if (volumes.length == values.length) {
            System.out.println(method(knapsackCapacity, volumes, values));
        } else {
            System.out.println("道具数量不一致。");
        }
        input.close();
    }

    public static int method(int knapsackCapacity, int[] volumes, int[] values) {
        if (volumes.length == 0 || values.length == 0)
            return 0;
        int[][] dp = new int[volumes.length + 1][knapsackCapacity + 1];
        for (int i = 1; i < volumes.length; i++) {
            for (int j = 1; j <= knapsackCapacity; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= volumes[i - 1])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - volumes[i - 1]] + values[i - 1]);
            }
        }
        return dp[volumes.length][knapsackCapacity];
    }
}
