package BiShe._360;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static int yxwj(String[] names) {
        if (names.length == 0 || names == null)
            return 0;
        if (names.length < 1 && names.length > 2000)
            return 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < names.length; i++) {
            set.add(names[i]);
        }
        int sum = 0;
        for (String temp : set) {
            char[] chars = temp.toLowerCase().toCharArray();
            if (chars.length > 10)
                continue;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] >= 97 && chars[j] <= 122) {
                    if (j == chars.length - 1)
                        sum++;
                    continue;
                } else
                    break;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
        System.out.println(yxwj(names));
    }

}
