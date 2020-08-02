package Thread;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);
        map.put(5, 1);
        map.put(6, 1);
        map.put(7, 1);
        for (int i = 0; i < map.size(); i++) {
            map.remove(1);
        }
        for (Object o : map.keySet()) {
            if ((int) o == 2) {
                map.remove(o);
            }
        }
        System.out.println(map.toString());
    }

}
