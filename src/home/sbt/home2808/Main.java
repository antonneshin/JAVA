package src.home.sbt.home2808;


/**
 * Created by Пентагон on 28.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        Calculator calc = new CalculatorImpl();
        System.out.println(calc.square(7));
        System.out.println(calc.square(8));
    }
}
