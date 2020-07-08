package LeetCode;

public class Offer58_1 {

    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = str.length-1; i >=0 ; i--) {
            if(!str[i].equals("")){
                builder.append(str[i]);
                builder.append(" ");
            }

        }
        return builder.toString().trim();
    }
}
