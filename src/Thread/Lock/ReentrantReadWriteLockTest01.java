package Thread.Lock;

import javax.sound.midi.Soundbank;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁执行顺序，读锁共享，写锁独享
 */
public class ReentrantReadWriteLockTest01 {
    //默认是非公平锁
    private static ReentrantReadWriteLock reentrantReadWritelock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readlock = reentrantReadWritelock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWritelock.writeLock();

    private static void read() {
        readlock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"得到读锁，正在读取");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+"释放读锁");
            readlock.unlock();
        }
    }


    private static void write() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"得到写锁，正在写入");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+"释放写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(()->read(),"Thread1").start();
        new Thread(()->read(),"Thread2").start();
        new Thread(()->write(),"Thread3").start();
        new Thread(()->write(),"Thread4").start();
    }

}
