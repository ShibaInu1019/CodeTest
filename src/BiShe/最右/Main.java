package BiShe.最右;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    final String x36 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String[] x36Array = "0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(",");

    public long transforToTen(String str) {
        if (str.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < x36.length(); i++) {
            map.put(x36.charAt(i), i);
        }
        int size = str.length();
        long num = 0;
        for (int i = 0; i < size; i++) {
            String s = String.valueOf(str.charAt(i)).toUpperCase();
            num = (long) ((map.get(s.charAt(0))) * Math.pow(36, size - i - 1) + num);
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Main m = new Main();
        System.out.println(m.transforToTen(s));
    }

}
