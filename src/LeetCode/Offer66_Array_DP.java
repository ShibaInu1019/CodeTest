package LeetCode;

public class Offer66_Array_DP {

    public int[] constructArr(int[] a) {
        if (a.length == 0 || a == null)
            return null;
        //构建乘积数组,从左上到右下对角线为1
        int[] b = new int[a.length];
        b[0] = 1;
        int temp = 1;
        //计算左下角乘积
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        //计算右上角乘积
        for (int i = a.length - 2; i >= 0; i--) {
            temp = temp * a[i + 1];
            //左半边乘右半边为b[i]
            b[i] = b[i] * temp;
        }
        return b;
    }
}
