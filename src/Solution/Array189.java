package Solution;

public class Array189 {

    //旋转数组
    // 借助一个临时数组存储旋转后的数组元素，最后再复制给原数组
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }
}
