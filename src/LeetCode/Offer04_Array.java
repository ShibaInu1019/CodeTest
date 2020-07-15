package LeetCode;

public class Offer04_Array {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix == null)
            return false;

        //从右上角开始查找
        int row = matrix.length;//行
        int col = matrix[0].length;//列

        //（i,j）为右上角元素坐标
        int i = 0;
        int j = col - 1;

        while (i < row && j >= 0) {
            //当前元素小于target，向下一行
            if (matrix[i][j] < target)
                i++;
            //当前元素大于target，向左一列
            else if (matrix[i][j] > target)
                j--;
            else
                return true;
        }
        return false;
    }
}
