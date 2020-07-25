package Thread.Atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.LongAdder;

/**
 * AtomicIntegerFieldUpdater使用
 */
public class AtomicIntegerFieldUpdaterDemo implements Runnable {
    static Candidate tom = new Candidate();
    static Candidate peter = new Candidate();
    public static AtomicIntegerFieldUpdater<Candidate> scUpdater =
            AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            peter.score++;
            //原子性自增
            scUpdater.getAndIncrement(tom);
        }
    }

    public static class Candidate {
         volatile int score;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("普通变量：" + peter.score);
        System.out.println("升级后变量：" + tom.score);
    }
}
