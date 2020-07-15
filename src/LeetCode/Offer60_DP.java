package LeetCode;

import java.time.temporal.Temporal;

public class Offer60_DP {

    public static double[] twoSum(int n) {
        //初始化1个骰子的概率数组
        double[] init = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};

        for (int i = 2; i <= n; i++) {
            //初始化n个骰子数组长度
            //n个骰子最小点数为n，最大点数为6n，个数就是6n-n+1=5n+1
            double[] temp = new double[i * 5 + 1];
            //循环init
            for (int j = 0; j < init.length; j++) {
                //计算所有点数的概率（乘积累加）
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += init[j] / 6;
                }
            }
            // 将temp赋值给init数组，进行下一轮循环
            init = temp;
        }
        return init;
    }

    public static void main(String[] args) {
        System.out.println(Offer60_DP.twoSum(3));
    }
}
