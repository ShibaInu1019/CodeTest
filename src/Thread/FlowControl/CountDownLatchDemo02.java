package Thread.FlowControl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch模拟多等一，裁判等5个运动员准备，然后开始
 */
public class CountDownLatchDemo02 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch begin = new CountDownLatch(1);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI + "等待发令枪...");
                    try {
                        begin.await();
                        System.out.println(finalI + "出发");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.submit(runnable);
        }
        Thread.sleep(2000);
        System.out.println("预备，开始！");
        begin.countDown();
        executorService.shutdown();
    }
}
