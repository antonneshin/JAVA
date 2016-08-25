package src.lesson2508;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by Student on 25.08.2016.
 */
public class MyFutureRunnable extends FutureTask {
    public MyFutureRunnable(Callable callable) {
        super(callable);
    }
    @Override
    public void run(){
        super.run();
        System.out.println("Post Method");
    }
}
