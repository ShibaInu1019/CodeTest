package Thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadDemo {

    private  static void  demo(){
        System.out.println("demo");
        System.out.println("demo Thread:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    demo();
                }
            };
        System.out.println("main Thread:"+Thread.currentThread().getName());
        t.start();
    }
}
