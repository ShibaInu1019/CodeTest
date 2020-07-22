package Thread.Lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 演示读锁在非公平情况下插队（等待队列中第一个是读锁才可以插队）
 */
public class ReentrantReadWriteLockTest02 {

    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);
    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();


    public static void read() {
        System.out.println(Thread.currentThread().getName() + "正在尝试获取读锁...");
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到读锁，正在读取...");
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放读锁");
            readLock.unlock();
        }
    }


    public static void write() {
        System.out.println(Thread.currentThread().getName() + "正在尝试获取写锁...");
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到写锁，正在写入...");
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> write(), "Thread1").start();
        new Thread(() -> read(), "Thread2").start();
        new Thread(() -> read(), "Thread3").start();
        //当Thread3得到读锁的时候，等待队列中第一个应该是Thread4写锁，子线程的读锁就无法进行插队
        new Thread(() -> write(), "Thread4").start();
        new Thread(() -> read(), "Thread5").start();
        //子线程进行读锁插队
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread[] threads = new Thread[1000];
                for (int i = 0; i < 1000; i++) {
                    threads[i] = new Thread(() -> read(), "子线程Thread" + i);
                }
                for (int i = 0; i < 1000; i++) {
                    threads[i].start();
                }
            }
        }).start();
    }

}

