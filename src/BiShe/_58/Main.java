package BiShe._58;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {


    public ArrayList<String> findCommonString(ArrayList<ArrayList<String>> values) {
        // write code here
        if (values.size() == 0)
            return null;
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < values.size(); i++) {
            ArrayList<String> list = new ArrayList<>();
            HashSet<String> set = new HashSet<>();
            for (int j = 0; j < list.size(); j++) {
                set.add(list.get(j));
            }
            for (String str : set) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == values.size()) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public int question(int a, int b) {
        // write code here
        for (int i = 0; i < 500; i++) {
            double x = Math.sqrt(i + a);
            double y = Math.sqrt(i + b);
            if (x == (int) x && y == (int) y)
                return i;
        }
        return 0;
    }

    public int translateNum(int num) {
        // write code here
        if (num < 10)
            return 1;
        if (num % 100 >= 10 && num % 100 <= 25)
            return translateNum(num / 10) + translateNum(num / 100);
        else
            return translateNum(num / 10);
    }

}
