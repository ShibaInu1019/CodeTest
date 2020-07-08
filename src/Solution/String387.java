package Solution;

import java.util.HashMap;
import java.util.Map;

public class String387 {

    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        for (int i = 0; i <n ; i++) {
            if(map.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {

        //定义一个HashMap
        Map<String, String> map = new HashMap<>();
        //向map中添加数据
        map.put("one", "aaa");
        map.put("two", "bbb");
        map.put("three", "ccc");

        //定义temp1    因为map中存在key="one"，所以temp1等于key="one"所对应的value="aaa"
        String temp1 = map.getOrDefault("one", "ddd");
        System.out.println("temp1:" + temp1);

        //定义temp2    因为map中不存在key="four"，所以temp1等于默认值"ddd"
        String temp2 = map.getOrDefault("four", "ddd");
        System.out.println("temp2:" + temp2);

    }


}
