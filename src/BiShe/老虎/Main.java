package BiShe.老虎;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static String frequencySort(String s) {
        // write code here
        if (s.length() == 0 || s == null)
            return null;
        char[] c = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c1 : c) {
            map.put(c1, map.getOrDefault(c1, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((x, y) -> (y.getValue() - x.getValue()));
        queue.addAll(map.entrySet());
        StringBuilder builder = new StringBuilder(s.length());
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                builder.append(entry.getKey());
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("traeeaaa"));
    }
}
