package Thread.Collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {


    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        Interviewer interviewer = new Interviewer(queue);
        Consumer consumer = new Consumer(queue);

        Thread in = new Thread(interviewer);
        Thread con = new Thread(consumer);
        in.start();
        con.start();
        in.join();
        con.join();


    }
}

class Interviewer implements Runnable {
    BlockingQueue queue;

    public Interviewer(BlockingQueue queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        System.out.println("十个候选人来了");
        for (int i = 0; i < 10; i++) {
            String man = "man" + i;
            try {
                queue.put(man);
                System.out.println("安排好了" + man);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            queue.put("stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("面试结束了");
    }
}


class Consumer implements Runnable {
    BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String msg;
        try {
            while (!(msg = (String) queue.take()).equals("stop")) {
                System.out.println(msg + "准备面试");

            }
            System.out.println("所有候选人都结束了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}