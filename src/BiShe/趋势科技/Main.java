package BiShe.趋势科技;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        String next = strings[0];
        String mid = strings[1];
        System.out.println(change(mid, next));
    }


    private static String change(String mid, String next) {
        if (mid.length() > 0) {
            int len = next.length();
            if (len == 1) {
                return next;
            }
            if (len <= 0 || len > 8) {
                return "";
            }
            char root = next.charAt(len - 1);
            int rootindex = mid.indexOf(root);

            return change(mid.substring(rootindex + 1), next.substring(rootindex, len - 1)) + change(mid.substring(0, rootindex), next.substring(0, rootindex))
                     +next.charAt(len - 1);
        } else {
            return "";
        }
    }
}



