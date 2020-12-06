package Thread;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new CallableDemo());
        new Thread(futureTask).start();
        if (!futureTask.isDone()) {
            System.out.println("Task is not finshed,Please wait");
        }
        System.out.println("Return value is " + futureTask.get());
    }
}
