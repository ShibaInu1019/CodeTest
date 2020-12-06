package Thread;

import java.util.Random;
import java.util.concurrent.*;

public class FutureDemo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future future = service.submit(new CallableTask());
        System.out.println(future.get());
        service.shutdown();
    }

    static class CallableTask implements Callable {

        @Override
        public Object call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt(100);
        }
    }
}
