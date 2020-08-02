package Thread;


import java.util.concurrent.locks.Lock;

/**
 * 栈封闭演示
 */
public class StackClosedDemo implements Runnable {

    int index = 0;

    public void inThread() {
        int partValue = 0;
        for (int i = 0; i < 10000; i++) {
            partValue++;
        }
        System.out.println("栈内保护数据是线程安全的partValue：" + partValue);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            index++;
        }
        inThread();
    }

    public static void main(String[] args) throws InterruptedException {
        StackClosedDemo stackClosedDemo = new StackClosedDemo();
        Thread t1 = new Thread(stackClosedDemo);
        Thread t2 = new Thread(stackClosedDemo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("线程共享变量：" + stackClosedDemo.index);
    }
}
