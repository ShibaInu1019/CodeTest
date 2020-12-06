package BiShe.伴鱼;

import java.util.Stack;

public class Main {

    public String baseNeg2(int N) {
        // write code here
        String res = "";
        char[] nums = new char[40005];
        Stack<Integer> s = new Stack<>();
        int a;
        if (N == 0)
            return "0";
        else {
            while (N != 0) {
                a = Math.abs(N % (-2));
                s.push(a);
                N = (N - a) / (-2);
            }
        }
        while (!s.isEmpty()) {
            res += s.pop();
        }
        return res;
    }
}
