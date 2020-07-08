package Solution;

public class Array26 {
    //删除   排序数组   中的重复项
    //返回新数组的长度
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int i = 0;
        for (int j =1 ;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
