package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Array136只出现一次的数字 {

    // 给定一个非空整数数组
    // 除了某个元素只出现一次以外，其余每个元素均出现了2次
    // 找出那个只出现了一次的元素。

    //求出现过一次的数字
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //定义返回值
        int res = 0;

        //如果hashset中存在num，res加上num；反之res减去num
        //即这个数字如果重复出现，会抵消，res并不会发生变化
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                res += num;
            } else {
                res -= num;
            }
        }
        //返回的res是只出现一次的数字
        return res;
    }


    // 异或 ⊕（XOR） 特点（相同为0，不同为1）
    //    XOR 满足交换律和结合律
    //     a 异或 0 = a
    //     a 异或 a = 0
    public int singleNumber01(int[] nums) {

        int res = 0;

        for (int num : nums) {
            res = res ^ num;
        }
        //两个相同的值 异或为0
        //返回的是 0 异或 只出现一次的数 = 只出现一次的数
        return res;
    }


}
