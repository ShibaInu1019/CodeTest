package JZOffer.数组;

/**
 * 这里我们可以申请一个临时数组temp，
 * 因为nums元素中的每个元素的大小都在0~n-1之间，
 * 所以我们可以把nums中元素的值和临时数组temp建立映射关系，
 * 就是nums中元素的值是几，我们就把temp中对应的位置值加1，
 * 当temp某个位置的值大于1的时候，
 * 就表示出现了重复，我们直接返回即可
 * <p>
 * <p>
 * hashset去重
 * 排序比较
 */
public class E03_数组中重复数字_映射 {
    public int findRepeatNumber(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < temp.length; i++) {
            temp[nums[i]]++;
            if (temp[nums[i]] > 1)
                return nums[i];
        }
        return -1;
    }
}
