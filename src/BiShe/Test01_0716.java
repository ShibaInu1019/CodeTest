package BiShe;

import java.util.Arrays;

public class Test01_0716 {


    public static int[] func1(int[][] order_list, int n) {
        // write code here
        if (order_list == null || n == 0 || order_list.length == 0)
            return null;
        int temp[][] = new int[n + 1][2];

        for (int i = 0; i < order_list.length; i++) {
            for (int j = order_list[i][0]; j <= order_list[i][1]; j++) {
                temp[j][0] = j;
                temp[j][1] += order_list[i][2];
            }
        }
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = temp[i][1];
        }
        return res;
    }


    public int func2(int[] a_times, int[] p_times) {
        // write code here
        int sum = 0;
        int min_ = Integer.MAX_VALUE;
        int min_num = Integer.MAX_VALUE;
        for (int i = 4; i < a_times.length; i++) {
            for (int j = 4; j >= 0; j--) {
                int min = a_times[i - j] + p_times[i - j];
                if (min < min_) {
                    min_num = Math.min(i - j, min_num);
                    min_ = min;
                }
            }
            a_times[min_num] = Integer.MAX_VALUE;
            p_times[min_num] = Integer.MAX_VALUE;
            sum += min_ - a_times[i];
        }
        return sum / a_times.length;
    }


    public int func3(int[] block_list, int[] unblock_list) {
        // write code here

        int sum = 0;
        for (int i = 0; i < block_list.length - 1; i++) {
            for (int j = 0; j < unblock_list.length; j++) {
                if (block_list[i + 1] - block_list[i] < 60) {
                    sum += block_list[i + 1] - block_list[i];
                } else if (block_list[i + 1] - block_list[i] >= 60) {
                    sum += 60;
                }

            }
        }
        return sum;
    }

    public int func4(int[] list) {
        // write code here
        int min = 0;
        int max = 0;
        int l = 0;
        int r = list.length - 1;
        int res = 0;

        while (l < r) {
            min = list[list[l] < list[r] ? l++ : r--];
            max = Math.max(min, max);
            res += max - min;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] order_list = {{2, 4, 10}, {0, 3, 15}, {3, 4, 21}};
        int res[] = Test01_0716.func1(order_list, 6);
        System.out.println(Arrays.toString(res));
    }
}


