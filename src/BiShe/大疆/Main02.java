package BiShe.大疆;

import java.util.Scanner;

public class Main02 {

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

    }
}
