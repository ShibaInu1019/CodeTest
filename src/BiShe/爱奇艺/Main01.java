package BiShe.爱奇艺;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main01 {

    public static String path(String path) {
        Set<String> p = new HashSet<>();
        int x = 0;
        int y = 0;
        p.add((x + "," + y));
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    x++;
                    break;
                case 'S':
                    x--;
                    break;
                case 'E':
                    y++;
                    break;
                case 'W':
                    y--;
                    break;
                default:
                    break;
            }
            if (!p.add(x + "," + y))
                return "True";
        }
        return "False";
    }

    public static void main(String[] args) {
        boolean n = false;
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(path(str));
    }
}
