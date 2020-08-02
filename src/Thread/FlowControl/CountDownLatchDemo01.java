package Thread.FlowControl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch演示一个线程需要等待多个线程执行完毕，在继续自己的工作
 */
public class CountDownLatchDemo01 {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(finalI + "开始检查");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(finalI + "完成检查");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            };
            threadPool.submit(runnable);
        }
        System.out.println("等待5个人检查");
        latch.await();
        threadPool.shutdown();
        System.out.println("检查结束");
    }

}
