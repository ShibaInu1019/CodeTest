package Thread;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        //指定线程数量的线程池
        ExecutorService pool1 = Executors.newFixedThreadPool(1);
        //缓存线程池
        ExecutorService pool2 = Executors.newCachedThreadPool();
        //单线程线程池
        ExecutorService pool3 = Executors.newSingleThreadExecutor();
        //周期性线程池
        ExecutorService pool4 = Executors.newScheduledThreadPool(1);
        //周期性单线程线程池
        ExecutorService pool5 = Executors.newSingleThreadScheduledExecutor();
        //Fork/Join线程池
        ExecutorService pool6 = Executors.newWorkStealingPool();

        //自定义线程池
        ExecutorService threadPool = new ThreadPoolExecutor(3, 6,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());


        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new CallableDemo());

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("创建线程");
//            }
//        };
//        executorService.submit(runnable);
//        executorService.execute(runnable);

        if (!future.isDone()) {
            System.out.println("Task is not finshed,Please wait");
        }
        try {
            System.out.println("Return value is " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
