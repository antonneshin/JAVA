package src.lesson2507;

/**
 * Created by Student on 25.07.2016.
 */
public class TestException {
    private static void a()
    {
        b();
    }
    private static void b()
    {
        c();
    }
    private static void c()
    {
        int x=1;
        int y=0;
        System.out.println(x/y);
    }
    public static void main(String[] args)
    {
        a();
    }
}
