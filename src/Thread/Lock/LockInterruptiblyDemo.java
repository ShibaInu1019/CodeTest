package Thread.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyDemo implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "尝试获取锁");
        try {
            lock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName() + "获取到了锁");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "睡眠期间被中断了");
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了锁");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "获得锁期间被中断了");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        LockInterruptiblyDemo demo = new LockInterruptiblyDemo();
        Thread thread0 = new Thread(demo);
        Thread thread1 = new Thread(demo);
        thread0.start();
        thread1.start();

        Thread.sleep(200);
        thread1.interrupt();
    }
}
