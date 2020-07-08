package LeetCode;

public class Offer15 {

    //计算二进制数中1的个数

    //在二进制表示中，数字 n 中最低位的 1 总是对应 n - 1 中的 0 。
    //因此，将 n 和 n - 1 与运算总是能把 n 中最低位的 1 变成 0 ，并保持其他位不变
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
