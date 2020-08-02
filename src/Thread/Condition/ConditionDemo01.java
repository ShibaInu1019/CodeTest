package Thread.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition基本使用
 */
public class ConditionDemo01 {

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    void method1() throws InterruptedException {
        reentrantLock.lockInterruptibly();
        try {
            System.out.println("条件不满足，开始await");
            condition.await();
            System.out.println("条件满足，开始执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    void method2() throws InterruptedException {
        reentrantLock.lockInterruptibly();
        try {
            System.out.println("准备工作完成，开始唤醒....");
            condition.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo01 demo01 = new ConditionDemo01();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    demo01.method2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        demo01.method1();
    }

}
