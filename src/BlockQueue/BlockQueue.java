package BlockQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue<T> {

    private int size;
    private Object[] queue;

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private int index;
    private int removeIndex;
    private int currLen;

    public BlockQueue(int size) {
        this.size = size;
        this.index = 0;
        this.removeIndex = 0;
        this.currLen = 0;
        queue = new Object[size];
    }

    public BlockQueue() {
        this(10);
    }

    public void push(T t) {
        lock.lock();
        try {
            while (currLen == size) {
                System.out.println("队列满...");
                condition.await();
            }
            queue[index] = t;
            index++;
            if (index == size) {
                index = 0;
            }
            currLen++;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T pop() throws InterruptedException {
        lock.lock();
        try {
            while (currLen == 0) {
                System.out.println("队列空...");
                condition.await();
            }
            Object o = queue[removeIndex];
            removeIndex++;
            if (removeIndex == size) {
                removeIndex = 0;
            }
            currLen--;
            condition.signal();
            return (T) o;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BlockQueue<Integer> queue = new BlockQueue();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    queue.push(i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        System.out.println(queue.pop());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
