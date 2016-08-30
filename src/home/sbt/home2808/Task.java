package src.home.sbt.home2808;

/**
 * Created by Пентагон on 31.08.2016.
 */
public class Task implements Runnable {

    private Calculator calculator;
    private final Integer arg;

    public Task(Integer arg, Calculator calc) {
        this.arg = arg;
        this.calculator = calc;
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" is working");
        System.out.println(calculator.square(arg));
    }
}
