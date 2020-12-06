package BiShe.其他;

import java.util.*;

/**
 * 抽取n个二等奖
 */
public class Test02_0727 {

    public static Set draw(String s1, String s2, int number, int n) {
        List<String> list1 = new ArrayList<>(Arrays.asList(s1.split(",")));
        List<String> list2 = Arrays.asList(s2.split(","));
        Iterator iterator = list1.iterator();
        for (int i = 0; i < number; i++) {
            while (iterator.hasNext()) {
                if (iterator.next().equals(list2.get(i))) {
                    iterator.remove();
                    break;
                }
            }
        }
        Random random = new Random();
        Set<String> res = new HashSet<>();
        int index = 0;
        while (res.size() < n) {
            index = random.nextInt(list1.size());
            res.add(list1.get(index));
        }
        return res;
    }


    public static void main(String[] args) {
        String s1 = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";
        String s2 = "2,5,6";
        Set<String> set = draw(s1, s2, 3, 5);
        System.out.println(set.toString());
    }
}
