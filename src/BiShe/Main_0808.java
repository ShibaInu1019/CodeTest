package BiShe;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main_0808 {

    /**
     * 更谁学笔试
     */
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] pair = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0, d = 1; i < n; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            }else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static int[] css(int[] arr, int n, int m) {
        if (arr.length == 0 || arr == null)
            return null;
        int sum = 1;
        int[] res = new int[n];
        for (int i = 1; i <= arr.length; i++) {
            if (arr[i] == 0) {
                res[i] = i;
            } else if (arr[i] != 0 && arr[i] != m) {
                res[i] = i;
            } else {
                res[i] = i;
                for (int j = 0; j < i; j++) {
                    if (arr[j] != 0) {
                        res[i + sum] = j;
                        sum++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = 0;
        }
        int b = scanner.nextInt();
        arr[b] = b;
        for (int i = 0; i < m - 1; i++) {
            int d = scanner.nextInt();
            arr[d] = d;
        }
        System.out.println(Arrays.toString(css(arr, n, b)));
    }
}
