package Solution;

import java.util.HashSet;
import java.util.Set;

public class Array137 {

    //给定一个非空整数数组
    // 除了某个元素只出现一次以外，其余每个元素均出现了3次
    // 找出那个只出现了一次的元素。

    public int singleNumber(int[] nums) {

        Set<Long> set = new HashSet<>();

        //统计整个数组的值
        long sum = 0;
        //将元素存进hashset去掉重复元素
        for (int num : nums) {
            set.add((long) num);
            sum += num;
        }

        //统计hashset的值
        long setSum = 0;
        for (Long s : set) {
            setSum += s;
        }

        // 3×(a+b+c)−(a+a+a+b+b+b+c)=2c
        //出现一次的数字就是c
        return (int) ((3 * setSum - sum) / 2);
    }
}
