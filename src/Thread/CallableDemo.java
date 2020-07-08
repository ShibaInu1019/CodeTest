package Thread;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        String res = "Hello";
        System.out.println("Call ready");
        Thread.currentThread().sleep(5000);
        System.out.println("Call down");
        return res;
    }
}
