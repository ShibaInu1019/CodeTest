package BiShe.美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Integer> nxs(int n) {

        List<Integer> list = new ArrayList<>();

        for (int j = 1000; j < n / 2; j++) {
            int a = 1;
            int nlength = 0;
            while (j / a != 0) {
                a *= 10;
                nlength++;
            }
            int[] arr = new int[nlength];
            a = a / 10;
            arr[0] = j / a;
            a = a / 10;
            for (int i = 1; i < nlength; i++) {
                arr[i] = (j / a) % 10;
                a /= 10;
            }

            for (int i = 0; i < arr.length / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = temp;
            }
            int b = 0;
            nlength--;
            for (int i = 0; i < arr.length; i++) {
                b += arr[i] * Math.pow(10, nlength);
                nlength--;
            }
            if (b == 4 * j) {
                list.add(j);
                list.add(b);
            }

        }
        return list;

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = nxs(n);
        System.out.println(list.size() / 2);
        for (int i = 0; i < list.size(); i = i + 2) {
            System.out.println(list.get(i) + " " + list.get(i + 1));
        }
    }
}
