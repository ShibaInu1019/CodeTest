package Thread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger操作与Integer对比
 */
public class AtomicIntegerDemo implements Runnable {

    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();
    private static volatile Integer basic = 0;

    public void AtomicAdd() {
        ATOMIC_INTEGER.getAndIncrement();
    }

    public void BasicAdd() {
        basic++;
    }


    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            AtomicAdd();
            BasicAdd();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo demo = new AtomicIntegerDemo();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("AtomicInteger:" + ATOMIC_INTEGER.get());
        System.out.println("Integer:" + basic);
    }
}
