package LeetCode;

public class Offer53最大子序和 {
    //全是负数找最大的负数
    //如果sum>0对当前遍历的数有增益效果，反之舍弃，sum变为当前遍历的数
    //每次和上次遍历得到的最大值进行比较

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = nums[0];

        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(sum, res);
        }
        return res;
    }
}
