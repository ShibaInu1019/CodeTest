package BiShe.滴滴;

import java.util.Scanner;

public class Main {


    public static String fg(int num, String str) {
        if (str == "" || str.length() == 0)
            return "";
        if (num >= str.length()) {
            StringBuilder builder = new StringBuilder(str);
            builder.reverse();
            return builder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0;i+num<str.length(); i += num) {
                    String temp = turn(str.substring(i, i + num));
                    stringBuilder.append(temp);
            }
            String temp = turn(str.substring((str.length()/num)*num, str.length()));
            stringBuilder.append(temp);
            return stringBuilder.toString();
        }
    }

    public static String turn(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = sc.next();
        System.out.println(fg(num, str));
    }


}
