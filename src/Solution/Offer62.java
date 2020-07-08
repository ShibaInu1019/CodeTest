package Solution;

public class Offer62 {

    //约瑟夫环  数学逆推
    public int lastRemaining(int n, int m) {
        int res = 0;
        //最后一轮剩下两个人  开始逆推
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}
