package LeetCode;

public class Offer10_2 {

    public int numWays(int n) {
        if(n==1 || n==0)
            return 1;

        int first = 1;
        int second = 2;

        for (int i=3;i<=n;i++){
            int third = (first + second)%1000000007;
            first = second;
            second = third;
        }
        return second;
    }
}
