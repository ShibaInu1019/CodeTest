package BiShe.大疆;

import java.util.*;

public class Main {

    public static int maxValue(int days, int[] cjz, int[] playday) {
        if (days < 1 || days > 1000)
            return 0;
        int max = 0;
        for (int i = 0; i < playday.length; i++) {
            if (cjz[i] < 0 || cjz[i] > 10000)
                return 0;
            if (playday[i] >= 1 && playday[i] <= 500) {
                if (playday[i] == days) {
                    if (cjz[i] > max) {
                        max = cjz[i];
                    }
                }
                if (playday[i] < days) {
                    for (int j = i + 1; j < playday.length; j++) {
                        if (playday[i] + playday[j] == days) {
                            if (cjz[i] + cjz[j] > max) {
                                max = cjz[i] + cjz[j];
                            }
                        }
                    }
                }
            } else
                return 0;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int play = sc.nextInt();
        int days = sc.nextInt();
        int[] cjz = new int[play];
        int[] playday = new int[play];
        for (int i = 0; i < play; i++) {
            cjz[i] = sc.nextInt();
            playday[i] = sc.nextInt();
        }
        System.out.println(maxValue(days, cjz, playday));
    }
}

