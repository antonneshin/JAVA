package src.lesson2508;

import java.util.RandomAccess;

/**
 * Created by Student on 25.08.2016.
 */
public class Task implements Runnable {
    private int id;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" - current thread");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
