package LeetCode;

import java.util.Arrays;

public class Offer45 {


    public String minNumber(int[] nums) {
        //int 转 String 数组
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        //30+3 < 3+30  ->  30 < 3   进行自定义排序
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        //拼接字符数组
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }
}
