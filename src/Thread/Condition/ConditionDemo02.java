package Thread.Condition;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition生产者消费者模式
 */
public class ConditionDemo02 {
    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void consume() throws InterruptedException {
            while (true) {
                lock.lockInterruptibly();
                try {
                    while (queue.size() == 0) {
                        System.out.println("queue为空，等待数据进入");
                        notEmpty.await();
                    }
                    queue.poll();
                    notFull.signalAll();
                    System.out.println("从队列中取走一个数据，队列剩余" + queue.size() + "个元素");
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void produce() throws InterruptedException {
            while (true) {
                lock.lockInterruptibly();
                try {
                    while (queue.size() == queueSize) {
                        System.out.println("queue已满，等待有空余");
                        notFull.await();
                    }
                    queue.offer(1);
                    notEmpty.signalAll();
                    System.out.println("向队列中插入一个数据，队列剩余" + (queueSize - queue.size()));
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ConditionDemo02 demo02 = new ConditionDemo02();
        Consumer consumer = demo02.new Consumer();
        Producer producer = demo02.new Producer();
        Thread t1 = new Thread(consumer);
        Thread t2 = new Thread(producer);
        t1.start();
        t2.start();
    }

}
