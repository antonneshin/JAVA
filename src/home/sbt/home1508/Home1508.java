package src.home.sbt.home1508;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Пентагон on 15.08.2016.
 */
@FunctionalInterface
interface MyFuncI <T>{
    double eval (T x, T y);
}
public class Home1508 {
    public static void main(String[] args) {
        MyFuncI<Integer> func;
        func = (x, y)->Math.sqrt(x.intValue()*x.intValue()+y.intValue()*y.intValue());
        double result = func.eval(1,2);
        System.out.println("sqrt(a^2+b^2) = " + result);

        List<Integer> ls= Arrays.asList(-1,2,3,-4,5,-6,-7,8,9,0);
        System.out.println("First out:");
        ls.stream().filter(elem -> elem%2==0).forEach(System.out::println);
        System.out.println("Second out:");
        ls.stream().filter(elem -> elem>0).forEach(System.out::println);
    }
}
