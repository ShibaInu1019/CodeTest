package Thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * lambda表达式
 */
public class FutureDemo02 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Callable<Integer> callable = () -> {
            Thread.sleep(1000);
            return new Random().nextInt(100);
        };
        Future future = service.submit(callable);
        System.out.println(future.get());
        service.shutdown();
    }


}
