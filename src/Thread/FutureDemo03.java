package Thread;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 批量提交future,并获取结果
 */
public class FutureDemo03 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Callable<Integer> callable = () -> {
            Thread.sleep(1000);
            return new Random().nextInt(100);
        };

        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Future future = service.submit(callable);
            futures.add(future);
        }

        for (int i = 0; i < 20; i++) {
            Future future = futures.get(i);
            System.out.println(future.get());
        }
        service.shutdown();
    }
}
