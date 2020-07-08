package Thread;

public class ThreadDemo {

    private  static void  demo(){
        System.out.println("demo");
        System.out.println("demo Thread:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    demo();
                }
            };
        System.out.println("main Thread:"+Thread.currentThread().getName());
        t.start();
    }
}
