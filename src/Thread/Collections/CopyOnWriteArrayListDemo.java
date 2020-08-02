package Thread.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    /**
     * ArrayList迭代时修改需要使用迭代器
     *
     * @param args
     */
    /*public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
            System.out.println(list);
        }
    }*/
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> copy = new CopyOnWriteArrayList<>();
        copy.add(1);
        copy.add(2);
        copy.add(3);
        copy.add(4);
        copy.add(5);
        copy.add(6);
        copy.add(7);
        copy.add(8);

        Iterator iterator = copy.iterator();

        while (iterator.hasNext()) {
            System.out.println(copy);
            int it = (int) iterator.next();
            System.out.println(it);
            if (it == 2) {
                //CopyOnWriteArrayList可以在迭代时修改
                copy.remove(2);
            }
            if (it == 4) {
                //加入9，但是只能遍历到8
                copy.add(9);
            }
        }

    }


}
