package BiShe.伴鱼;

public class Main01 {
    public int movingCount(int m, int n, int k) {
        // write code here
        if (m < 0 || n < 0 || k < 0) {
            return 0;
        }
        boolean[] visited = new boolean[m * n];
        int count = movingCountCore(k, 0, m, 0, n, visited);
        return count;

    }

    private int movingCountCore(int k, int row, int rows, int col, int cols, boolean[] visited) {
        int res = 0;
        if (row >= 0 && row < rows && col >= 0 && col < cols && visited[row * cols + col] == false) {
            if (splitNum(row) + splitNum(col) <= k) {
                visited[row * cols + col] = true;
                res = 1 + movingCountCore(k, row - 1, rows, col, cols, visited) +
                        movingCountCore(k, row - 1, rows, col, cols, visited) +
                        movingCountCore(k, row, rows, col + 1, cols, visited) +
                        movingCountCore(k, row, rows, col - 1, cols, visited);
            }
        }
        return res;
    }

    private int splitNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

}
