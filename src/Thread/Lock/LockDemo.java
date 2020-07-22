package Thread.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try {
            //获取锁保护的资源
            System.out.println(Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }

    }
}
