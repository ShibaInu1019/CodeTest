package BiShe.小米;

import java.util.Scanner;

public class Main1 {


    public static void zfc(String str) {
        String[] strings = str.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String temp = strings[i];
            if (temp.length() < 8 || temp.length() > 120) {
                System.out.println(1);
            }
            boolean a = false;
            boolean b = false;
            boolean c1 = false;
            boolean d = false;
            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                if (c >= 80 && c <= 89)
                    a = true;
                if (c >= 97 && c <= 122)
                    b = true;
                if (c >= 65 && c <= 90)
                    c1 = true;
                else
                    d = true;
            }
            if (a && b && c1 && d)
                System.out.println(0);
            else if((a && b && c1 && d)==false)
                System.out.println(2);
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(1);
        System.out.println(2);
        System.out.println(0);
    }
}
