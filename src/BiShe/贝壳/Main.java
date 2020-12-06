package BiShe.贝壳;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static int hwc(int a, String str) {

        char[] strs = str.toCharArray();
        int sum = 0;
        Stack<Character> queue = new Stack<>();
        if (strs.length % 2 != 0) {
            if (strs[strs.length / 2] == strs[0]) {
                for (int i = 0; i < strs.length / 2; i++) {
                    queue.push(strs[i]);
                }
                for (int i = strs.length / 2 + 1; i < strs.length; i++) {
                    if (!queue.pop().equals(strs[i]))
                        sum++;
                }
            } else {
                sum++;
                for (int i = 0; i < strs.length / 2; i++) {
                    queue.push(strs[i]);
                }
                for (int i = strs.length / 2 + 1; i < strs.length; i++) {
                    if (!queue.pop().equals(strs[i]))
                        sum++;
                }
            }
        } else if (strs.length % 2 == 0) {
            for (int i = 0; i < strs.length / 2; i++) {
                queue.push(strs[i]);//ac
            }
            for (int i = (strs.length / 2); i < strs.length; i++) {
                if (!queue.pop().equals(strs[i]))
                    sum++;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String str = sc.next();
        System.out.println(hwc(a, str));
    }
}
