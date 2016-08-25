package src.lesson2508;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Student on 25.08.2016.
 */
public class TaskMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyFutureRunnable futureTask = new MyFutureRunnable(new MyCallable());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(futureTask);
        if (!futureTask.isDone()){
            System.out.println(futureTask.get());
        }
        executorService.shutdown();
    }
}
