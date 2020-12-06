package BiShe.美团;

import java.util.Scanner;

public class Main01 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 2 * n; i++) {
            builder.append(sc.next()).append(" ");
        }
        String[] place = builder.toString().split(" ");
        int i = 0, j = 1;
        int count = 0;
        while (j < place.length) {
            if (place.length == 4) {
                count = 1;
                break;
            }
            String first = place[i];
            String second = place[j];
            j++;
            if (place[i].equals(place[j])) {
                count++;
                i = j + 1;
                j = j + 2;
            }
        }
        System.out.println(count);
    }
}
