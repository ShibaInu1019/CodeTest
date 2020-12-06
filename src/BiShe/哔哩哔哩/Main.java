package BiShe.哔哩哔哩;

import java.util.Stack;

public class Main {

    public boolean IsValidExp(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        if (s.length() == 0) return true;
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() && (c == ')' || c == ']' || c == '}')) {
                return false;
            }
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            if (c == ')') {
                if (stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            } else if (c == ']') {
                if (stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            } else if (c == '}') {
                if (stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public int GetCoinCount(int N) {
        // write code here
        int M = 1024 - N;
        int dp[] = new int[1024];
        for (int i = 1; i <= M; i++)
            dp[i] = 100001;
        dp[0] = 0;
        int[] arr = new int[]{1, 4, 16, 64};
        for (int i = 0; i < 4; i++) {
            for (int j = arr[i]; j <= M; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
        return dp[M];
    }

    boolean res = false;

    public boolean Game24Points(int[] arr) {
        // write code here
        if (arr.length == 0 || arr == null)
            return false;
        recur(arr, 1, arr[0]);
        return res;
    }

    private void recur(int[] arr, int index, int sum) {
        if (index >= arr.length || res == true) {
            if (sum == 24)
                res = true;
            return;
        }
        recur(arr, index + 1, sum + arr[index]);
        recur(arr, index + 1, sum - arr[index]);
        recur(arr, index + 1, sum * arr[index]);
        if (arr[index] != 0)
            recur(arr, index + 1, sum / arr[index]);
    }


}
