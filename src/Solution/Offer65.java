package Solution;

public class Offer65 {

    public int add(int a, int b) {
        while (b != 0) {//进位为0跳出循环
            int c = (a & b) << 1;//c为进位和
            a ^= b;//a为非进位和
            b = c;//b=进位
        }
        return a;
    }
}
