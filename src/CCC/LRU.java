package CCC;

import java.util.*;

public class LRU {

    private int capacity;
    private Map<Integer, Integer> map = new LinkedHashMap<>();

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
            map.remove(key);
        else if (map.size() >= capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }


    public int[] LRU(int[][] operators, int k) {
        // write code here
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>
                ((int) Math.ceil(k / 0.75 + 1), 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > k;
            }
        };
        List<Integer> list = new ArrayList<>();
        for (int[] operator : operators) {
            if (operator.length == 3) {
                map.put(operator[1], operator[2]);
            } else if (operator.length == 2) {
                Integer value = map.get(operator[1]);
                if (value == null)
                    list.add(-1);
                else
                    list.add(value);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    class Lru {
        private int capacity;
        private Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>
                ((int) Math.ceil(capacity / 0.75 + 1), 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };

        public Lru(int capacity) {
            this.capacity = capacity;
        }

        public void put(int key, int value) {
            map.put(key, value);
        }

        public int get(int key) {
            return (map.get(key) == null) ? -1 : map.get(key);
        }
    }

    class Lruu {
        private int capacity;
        private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>((int) Math.ceil(capacity / 0.75 + 1), 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };

        public Lruu(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            return (map.get(key) == null) ? -1 : map.get(key);
        }

        public void put(int key, int value) {
            map.put(key, value);
        }


    }


}
