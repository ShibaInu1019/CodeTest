package Thread.FlowControl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch模拟多等一与一等多；
 * 多等一是5个运动员等1个裁判发令开始跑步；
 * 一等多是终点裁判员等5个运动员到达重点结束比赛。
 */
public class CountDownLatchDemo03 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI + "等待发令枪...");
                    try {
                        begin.await();
                        System.out.println(finalI + "开始跑步");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(finalI + "跑到终点了");
                        end.countDown();
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
        end.await();
        System.out.println("比赛结束");
        executorService.shutdown();
    }
}
