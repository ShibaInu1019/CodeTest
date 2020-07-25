package Thread.Atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class AccumulatorDemo {

    public static void main(String[] args) {
        LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x * y, 1);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    longAccumulator.accumulate(finalI);
                }
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println(longAccumulator.getThenReset());
    }

}
