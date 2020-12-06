package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Offer56数组中数字出现的次数1 {

    public int singleNumber(int[] nums) {

        if (nums.length == 0 || nums == null)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1)
                return key;
        }
        return 0;
    }
}
