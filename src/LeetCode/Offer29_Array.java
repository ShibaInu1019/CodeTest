package LeetCode;

public class Offer29_Array {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix == null)
            return new int[0];
        //定义上下左右边界
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        //用来计数
        int x = 0;
        //初始化res数组长度
        int res[] = new int[(r + 1) * (b + 1)];
        while (true) {
            //从左到右打印上边界
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            //内缩
            t = t + 1;
            //终止打印
            if (t > b) break;
            //从上到下打印右边界
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            r = r - 1;
            if (l > r) break;
            //从右到左打印下边界（注意for循环条件）
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            ;
            b = b - 1;
            if (t > b) break;
            //从下到上打印左边界（注意for循环条件）
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            l = l + 1;
            if (l > r) break;
        }
        return res;
    }
}
