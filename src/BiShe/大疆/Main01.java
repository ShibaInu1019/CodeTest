package BiShe.大疆;

import java.util.Scanner;

public class Main01 {

    public static String ssz(String s, int n) {
        int length = s.length() - n;
        char[] stack = new char[s.length()];
        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (top > 0 && stack[top - 1] > c && n > 0) {
                top--;
                n--;
            }
            stack[top] = c;
            top++;
        }
        int offset = 0;
        while (offset < length && stack[offset] == '0') {
            offset++;
        }
        return offset == length ? "0" : new String(stack, offset, length - offset);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        System.out.println(Integer.parseInt(ssz(s, n)));
    }
}
