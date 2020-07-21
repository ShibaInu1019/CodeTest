package Thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal 每个线程独享一个对象（多数为工具类，非线程安全）
 */
public class ThreadLocalDemo01 {

    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat simpleDateFormat = ThreadLocalFormat.simpleDateFormatThreadLocal.get();
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int finali = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalDemo01().date(finali);
                    System.out.println(Thread.currentThread().getName() + "," + date);
                }
            });
        }
        threadPool.shutdown();
    }


    static class ThreadLocalFormat {
        public static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            }
        };
    }

}
