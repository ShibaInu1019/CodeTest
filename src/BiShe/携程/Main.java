package BiShe.携程;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static int[] divingBoard(int a, int b, int k) {

        if (k <= 0 || a < 0 || b < 0)
            return new int[0];
        if (a >= 0 && b >= 0) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i <= k; i++) {
                int s = a * i + b * (k - i);
                set.add(s);
            }
            int index = 0;
            int[] res = new int[set.size()];
            for (Integer num : set) {
                res[index++] = num;
            }
            Arrays.sort(res);
            return res;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res;

        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = divingBoard(_a, _b, _k);
        String value = "[]";
        if (res != null && res.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                if (i == 0) {
                    stringBuilder.append("[");
                }
                stringBuilder.append(res[i]);
                if (i == res.length - 1) {
                    stringBuilder.append("]");
                } else {
                    stringBuilder.append(",");
                }
            }
            value = stringBuilder.toString();
        }
        System.out.println(value);
    }
}
