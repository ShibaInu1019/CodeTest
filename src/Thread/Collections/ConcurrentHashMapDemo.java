package Thread.Collections;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap组合操作出现线程安全问题
 */
public class ConcurrentHashMapDemo implements Runnable {

    private static ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        concurrentHashMap.put("小张", 0);
        ConcurrentHashMapDemo concurrentHashMapDemo = new ConcurrentHashMapDemo();
        Thread t1 = new Thread(concurrentHashMapDemo);
        Thread t2 = new Thread(concurrentHashMapDemo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(concurrentHashMap.get("小张"));
    }


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            while (true) {
                //先get在put是组合操作，导致线程不安全
                Integer socres = concurrentHashMap.get("小张");
//              socres++;
//              concurrentHashMap.put("小张", socres);
                int newscore = socres + 1;
                //发现小张现在值是socres，就原子的把socres更新为newscore
                //可能成功也有可能失败，失败的原因就是有线程修改了值
                boolean b = concurrentHashMap.replace("小张", socres, newscore);
                //当b为true时候跳出while，执行下次for循环
                if (b) {
                    break;
                }
            }
        }
    }
}
