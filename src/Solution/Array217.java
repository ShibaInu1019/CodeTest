package Solution;

import java.util.HashSet;
import java.util.Set;

public class Array217 {

    //判断数组中是否存在重复元素
    //方法一  hashset
    //方法二  排序比较前后元素是否相等
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums == null)
            return false;

        Set<Integer> hashset = new HashSet<>(nums.length);

        for (int num : nums) {
            if (hashset.contains(num))
                return true;
            hashset.add(num);
        }
        return false;
    }
}
