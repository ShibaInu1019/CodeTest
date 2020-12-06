package JZOffer.数组;

import java.util.HashMap;
import java.util.Map;

public class 数组中只出现一次的两个数字 {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        int[] nums = new int[2];
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                nums[count++] = entry.getKey();
            }
        }
        num1[0] = nums[0];
        num2[0] = nums[1];

    }
}



