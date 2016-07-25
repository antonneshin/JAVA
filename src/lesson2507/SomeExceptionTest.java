package src.lesson2507;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Student on 25.07.2016.
 */
public class SomeExceptionTest {
    public static void main(String[] args) {
        try
        {
            //Integer.parseInt("I'm not a number");
            //new URL("this is not URL!");

            int i=1/0;
            new URL("www.google.com").getContent();
        }catch (NumberFormatException e)
        {
            System.out.println(e.toString());
        } catch (MalformedURLException e)
        {
            System.out.println(e.toString());
        }catch (IOException|ArithmeticException e)
        {
            System.out.println(e.toString());
        }
    }
}
