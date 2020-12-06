package BiShe.MHY;

import java.util.Scanner;

public class Main {

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] temp = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            builder.append(temp[i]);
        }
        String[] num = builder.toString().split("\\D+");
        String[] ch = builder.toString().split("\\d+");
        int[] nums = new int[10];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(num[i]);
        }
        char op = ch[2].charAt(0);
        int fen = 0, mu = 0;
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        int d = nums[3];
        if (op == '+') {
            mu = b * d / gcd(b, d);
            fen = mu / b * a + mu / d * c;
        } else if (op == '-') {
            mu = b * d / gcd(b, d);
            fen = mu / b * a - mu / d * c;
        } else if (op == '*') {
            mu = b * d;
            fen = a * c;
        } else if (op == '\\') {
            fen = a * d;
            mu = b * c;
        }
        int aa = Math.abs(gcd(fen, mu));
        fen /= aa;
        mu /= aa;
        if (fen == mu || fen == -mu)
            System.out.println(fen / mu);
        else if (fen == 0)
            System.out.println(0);
        else
            System.out.println(fen + "/" + mu);
    }
}

