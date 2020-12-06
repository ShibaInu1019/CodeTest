package JZOffer.数组;

public class E29_顺时针打印矩阵_边界限定 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix == null)
            return new int[0];
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        int x = 0;
        int res[] = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            t++;
            if (t > b)
                break;
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            r--;
            if (l > r)
                break;
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            b--;
            if (t > b)
                break;
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            l++;
            if (l > r)
                break;
        }
        return res;
    }

}
