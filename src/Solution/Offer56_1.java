package Solution;

import java.util.HashMap;
import java.util.Map;

public class Offer56_1 {

    public int[] singleNumbers(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int res[] = new int[2];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                res[count] = key;
                count++;
            }
        }
        return res;
    }

}
