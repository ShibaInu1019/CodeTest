package Thread.Atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * AtomicArray使用方法
 */
public class AtomicArrayDemo {

    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(1000);

        Decrement decrement = new Decrement(atomicIntegerArray);
        Increment increment = new Increment(atomicIntegerArray);

        Thread[] thread1 = new Thread[100];
        Thread[] thread2 = new Thread[100];

        for (int i = 0; i < 100; i++) {
            thread1[i] = new Thread(decrement);
            thread2[i] = new Thread(increment);
            thread1[i].start();
            thread2[i].start();
        }

        for (int i = 0; i < 100; i++) {
            try {
                thread1[i].join();
                thread2[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            System.out.println(atomicIntegerArray.get(i));
        }
        System.out.println("执行结束");
    }
}

class Decrement implements Runnable {
    private AtomicIntegerArray array;

    public Decrement(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndDecrement(i);
        }
    }
}

class Increment implements Runnable {
    private AtomicIntegerArray array;

    public Increment(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndIncrement(i);
        }
    }
}
