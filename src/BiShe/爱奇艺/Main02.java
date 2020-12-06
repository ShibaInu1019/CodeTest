package BiShe.爱奇艺;

import java.util.Scanner;
import java.util.Stack;

public class Main02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(stack(str));
    }

    private static String stack(String str) {
        if (str.length() == 0 || str == null)
            return "False";
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())
                return "False";

        }
        if (stack.isEmpty())
            return "True";
        else
            return "False";
    }
}
