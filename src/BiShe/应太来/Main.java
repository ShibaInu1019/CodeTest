package BiShe.应太来;

import java.util.Scanner;

public class Main {

    public static int one(String haystack, String needle) {
        if (needle.length() == 0 || needle.equals("") || needle == "" || needle == null)
            return 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.lastIndexOf("")!=-1){
            String[] string = s.split(" ");
            System.out.println(one(string[0], string[1]));
        }else{
            System.out.println(0);
        }
    }

}
