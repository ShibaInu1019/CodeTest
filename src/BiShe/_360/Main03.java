package BiShe._360;

import java.util.Arrays;
import java.util.Scanner;

public class Main03 {


    public static void main(String[] args) throws IndexOutOfBoundsException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (str.length() > 3000 || str.length() <= 0)
            return;
        String[] strs = str.split("n");

        for (int i = 0; i < strs.length; i++) {
            StringBuilder builder = new StringBuilder("N");
            if (i == 0) {
                char first = strs[i].charAt(0);
                first = (char) (first - 32);
                String last = strs[i].substring(1, strs[i].length());
                System.out.println(new StringBuilder().append(first).append(last));
            } else
                System.out.println(builder.append(strs[i]).toString());
        }
    }

}
