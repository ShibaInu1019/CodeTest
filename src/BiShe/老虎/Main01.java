package BiShe.老虎;

public class Main01 {

    public int uniquePaths(int[][] arr) {
        // write code here
        int col = arr[0].length;
        int row = arr.length;
        if (col == 0 || row == 0)
            return 0;
        int[][] dp = new int[row][col];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}
