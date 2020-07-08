package LeetCode;

public class Offer64 {

    //递归
    public int sumNums(int n) {
        //短路&& 构造递归终止条件
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
