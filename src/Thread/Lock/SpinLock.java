package Thread.Lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁演示
 */
public class SpinLock {
    private AtomicReference<Thread> sign = new AtomicReference<>();

    private void lock() {
        Thread cur = Thread.currentThread();
        while (!sign.compareAndSet(null, cur)) {
            System.out.println("自旋获取失败，再次尝试...");
        }
    }


    private void unlock() {
        Thread cur = Thread.currentThread();
        sign.compareAndSet(cur, null);
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "尝试获取自旋锁");
                spinLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取到了自旋锁");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    spinLock.unlock();
                    System.out.println(Thread.currentThread().getName() + "释放了自旋锁");
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
