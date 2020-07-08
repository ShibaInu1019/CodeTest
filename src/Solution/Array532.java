package Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Array532 {
    public int findPairs(int[] nums, int k) {
        if (k < 0)
            return 0;
        //排序保证是大减小
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[j] - nums[i] == k)
                    map.put(nums[j], nums[i]);
        return map.size();
    }


}