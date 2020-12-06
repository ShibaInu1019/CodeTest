package BiShe._58;

import java.util.Arrays;
import java.util.Scanner;

public class Main02 {

    public static String sort(char[] ch) {
        char temp = 0;
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch.length - 1; j++) {
                if (ch[j] > ch[j + 1]) {
                    temp = ch[j + 1];
                    ch[j + 1] = ch[j];
                    ch[j] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(ch));
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ch = sc.next().toCharArray();
        System.out.println(sort(ch));
    }
}
