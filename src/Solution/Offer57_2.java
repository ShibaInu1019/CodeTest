package Solution;

import java.util.ArrayList;
import java.util.List;

public class Offer57_2 {

    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> list = new ArrayList<>();

        //因为题目要求数组中最少两个数  
        while (left <= target / 2) {
            if (sum < target) {
                sum = sum + right;
                right++;
            } else if (sum > target) {
                sum = sum - left;
                left++;
            } else {
                //记录结果
                int[] res = new int[right - left];
                for (int i = left; i < right; i++) {
                    res[i - left] = i;
                }
                list.add(res);
                sum = sum - left;
                left++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
