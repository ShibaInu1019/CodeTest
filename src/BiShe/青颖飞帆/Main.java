package BiShe.青颖飞帆;

import java.util.Iterator;
import java.util.List;

public class Main {

    public static List<Integer> test(List<Integer> list, int n) {
        if (list.size() == 0)
            return null;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(n)) {
                iterator.remove();
            }
        }
        return list;
    }

    //单例模式
    public static class Singleton {
        private volatile static Singleton instance;

        private Singleton() {
        }

        static Singleton getInstance() {
            //第一次检测
            if (instance == null) {
                //同步
                synchronized (Singleton.class) {
                    if (instance == null)
//可能会导致指令重排所以使用volatile修饰instance
                        instance = new Singleton();
                }
            }
            return instance;
        }
    }

    static class Singal {
        private static volatile Singal singal;

        public Singal() {
        }

        public Singal getSingal() {
            if (singal == null) {
                synchronized (Singal.class) {
                    if (singal == null)
                        singal = new Singal();
                }
            }
            return singal;
        }
    }


    public static void test() {
     /*   long starTime=System.currentTimeMillis();
        long endTime=System.currentTimeMillis();
        long Time=endTime-starTime;*/
        System.out.println("Hello World");
    }

}