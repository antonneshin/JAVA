package src.home.sbt.home2808;


import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Пентагон on 28.08.2016.
 */
public class Main {
    public static void main(String[] args) {
//        Calculator calc = new CalculatorImpl();
//        System.out.println(calc.square(7));
//        System.out.println(calc.square(8));
        Calculator calc = (Calculator)Proxy.newProxyInstance(CalculatorImpl.class.getClassLoader(),
                CalculatorImpl.class.getInterfaces(), new InvocationHandlerImpl<>(CalculatorImpl.class));
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Task(i,calc));
        }

        executorService.shutdown();
    }
}
