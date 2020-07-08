package LeetCode;

public class Offer17 {

    public int[] printNumbers(int n) {

        int []res = new int[(int) Math.pow(10,n)];

        for (int i = 0; i <res.length ; i++) {
            res[i] = i+1;
        }
            return res;
    }
}
