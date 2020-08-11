package Thread;

import java.util.concurrent.*;

public class FutrueTaskDemo {

    public static void main(String[] args) {

        FutureTask futureTask = new FutureTask(new Task());
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(futureTask);
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    static class Task implements Callable {
        @Override
        public Object call() throws Exception {
            System.out.println("任务正在执行...");
            Thread.sleep(1000);
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            return sum;
        }
    }

}
