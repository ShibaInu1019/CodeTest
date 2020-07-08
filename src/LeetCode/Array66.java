package LeetCode;

public class Array66 {


    //加一
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;//判断是否有进位  例如digits[i]=9
            if (digits[i] != 0) { //digits[i] != 0表示无进位  直接返回
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }
}
