package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Offer48 {


    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null)
            return 0;
        int res = 0;
        //定义左边界
        int left = -1;
        //定义hashmap
        HashMap<Character, Integer> hashMap = new HashMap<>();
        //循环字符串s
        for (int i = 0; i < s.length(); i++) {
            //存储每个char字符
            char temp = s.charAt(i);
            //如果map中存在这个char
            if (hashMap.containsKey(temp)) {
                //更新左边界
                left = Math.max(left, hashMap.get(temp));
            }
            //添加新的char
            hashMap.put(temp, i);
            //更新窗口长度
            res = Math.max(res, i - left);
        }
        return res;
    }

    public int lengthOfLongestSubstring_(String s) {
        if (s.length() == 0 || s == null)
            return 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, l = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}
