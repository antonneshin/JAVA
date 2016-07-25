package src.lesson2507;

/**
 * Created by Student on 25.07.2016.
 */
public class StackOverflowTest {
    static int count;
    public static void main(String[] args)
    {
        System.out.println(count++);
        main(args);
    }
}
