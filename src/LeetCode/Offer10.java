package LeetCode;

public class Offer10 {


    public int fib(int n) {
        if(n == 0)
            return 0;

        int one = 1;
        int two = 1;
        for(int i = 3;i<=n;i++){
            int three = (one + two)%1000000007;
            one = two;
            two = three;
        }
        return two;
    }
}
