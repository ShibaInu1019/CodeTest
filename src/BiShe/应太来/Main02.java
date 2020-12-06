package BiShe.应太来;

import java.util.Scanner;

public class Main02 {

    public static int two(int[] nums) {
        int max = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.substring(1, s.length() - 1).split(",");
        int [] arr = new int[str.length];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(two(arr));
    }
}
