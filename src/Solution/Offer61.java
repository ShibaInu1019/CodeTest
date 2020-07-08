package Solution;

import java.util.Arrays;

public class Offer61 {


    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int king = 0;
        //由于nums[i + 1]防止数组越界，i < nums.length - 1
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0)
                king++;
                //除了王，牌重复了
            else if (nums[i] == nums[i + 1])
                return false;
        }
        return nums[nums.length - 1] - nums[king] < 5;
    }
}
