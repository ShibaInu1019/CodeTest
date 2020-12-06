package BiShe.应太来;


import java.util.ArrayList;
import java.util.Scanner;

public class Main03 {

    static class Sheep {
        public int age = 1;
    }
    public static int get(int n, int[] arr, int died) {
        ArrayList<Sheep> Sheeps = new ArrayList<>();
        Sheeps.add(new Sheep());
        ArrayList<Sheep> addSheeps = new ArrayList<>();
        ArrayList<Sheep> delSheeps = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (Sheep sheep : Sheeps) {
                for (int j = 0; j < arr.length; j++) {
                    if (sheep.age == arr[j]) {
                        Sheep Temp = new Sheep();
                        Temp.age++;
                        addSheeps.add(Temp);
                    }
                }
                if (sheep.age == died) {
                    delSheeps.add(sheep);
                }
                sheep.age++;
            }
            Sheeps.addAll(addSheeps);
            Sheeps.removeAll(delSheeps);
            addSheeps.clear();
            delSheeps.clear();
        }
        return Sheeps.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < 2; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int died = Integer.parseInt(s[2]);
        int year = Integer.parseInt(s[3]);
        System.out.println(get(year, arr, died));
    }
}



