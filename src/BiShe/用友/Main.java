package BiShe.用友;


public class Main {


    public static String compress(String str) {
        if (str.length() == 0 || str == null)
            return null;
        StringBuilder builder = new StringBuilder();
        char[] chars = str.toCharArray();
        int count = 1;
        int i = 0;
        while (i < str.length() - 1) {
            if (chars[i] == chars[i + 1]) {
                count++;
                i++;
                if (i == str.length() - 1)
                    builder.append(chars[i]).append(count);
            } else {
                builder.append(chars[i]).append(count);
                i++;
                count = 1;
            }
        }
        if (builder.toString().length() > str.length())
            return str;
        else
            return builder.toString();
    }

    public static void main(String[] args) {
        String s = "abbccdddaaaa";
        System.out.println(compress(s));
    }


}
