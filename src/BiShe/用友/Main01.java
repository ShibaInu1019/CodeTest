package BiShe.用友;

import java.util.ArrayList;

public class Main01 {
    public int[][] convert(int[][] matrix) {
        // write code here
        if (matrix.length == 0 || matrix == null)
            return null;
        int temp = 0;
        int col = matrix[0].length;
        int row = matrix.length;
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[row - i - 1][j];
                matrix[row - i - 1][j] = temp;
            }
        }
        return matrix;
    }
}
