package src.lesson2207;

/**
 * Created by Student on 22.07.2016.
 */
public class B extends A {
    public static <T> String getType(T obj)
    {
        return obj.getClass().getTypeName();
    }
}
