package Thread;

public class Sleep_Wait {
    public static void main(String[] args) {
        final Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ThreadA is waiting get lock");
                synchronized (lock) {

                    System.out.println("ThreadA get lock");
                    try {
                        Thread.sleep(20);
                        System.out.println("ThreadA do sleep");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ThreadA is done");
                }

            }
        }).start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ThreadB is waiting get lock");
                synchronized (lock) {
                    System.out.println("ThreadB get lock");
                    try {
                        System.out.println("ThreadB is sleeping 20ms");
                        Thread.sleep(20);
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ThreadB is done");
                }
            }
        }).start();

    }
}
