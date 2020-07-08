package LeetCode;

public class String125 {
    public static void main(String[] args) {
        //定义char
        char small = 'a';
        char big = 'B';

        //如果直接输出char类型输出的是ASCII码，所以进行强制转换
        System.out.println("小写'a'转大写："+(char) (small & 0xDF));
        System.out.println("大写'B'转小写："+(char) (big & 0xDF));
    }

    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();

        int i = 0;
        int j= lower.length()-1;

        while (i<j){
            if (!Character.isLetterOrDigit(lower.charAt(i))){
                i++;
                continue;
            }

            if(!Character.isLetterOrDigit(lower.charAt(j))){
                j--;
                continue;
            }

            if(lower.charAt(i)!=lower.charAt(j))
                return false;
            else{
                i++;
                j--;
            }

        }
        return true;
    }
}
