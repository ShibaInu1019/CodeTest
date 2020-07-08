package Solution;


import java.util.Arrays;

public class String242 {


    public boolean isAnagram(String s, String t) {
        char[] t1 = s.toCharArray();
        char[] t2 = t.toCharArray();

        Arrays.sort(t1);
        Arrays.sort(t2);

        if (new String(t1).equals(new String(t2)))
            return true;
        else
            return false;
    }
}
