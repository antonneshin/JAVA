package src.lesson0108;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Student on 01.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        /*System.out.println(1);
        try {
            Person person = (Person)Main.class.getClassLoader().loadClass("src.lesson0108.Person").newInstance();//new Person()
        } catch (Exception e){
            System.out.println("error = "+e.getMessage());
            e.printStackTrace();
        }
        System.out.println(2);*/

        /*
        try {
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("file:/J:/lecture7/person.jar")},null);
            Class<?> perssClazz=urlClassLoader.loadClass("ru.sbt.bvv.lecture7.Person");
            Method method=perssClazz.getDeclaredMethod("info");
            method.invoke(perssClazz.newInstance());
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("error = "+e.getMessage());
        }*/

        /*
        try {
            for (int i = 0; i < 1_000_000; i++) {
                new URLClassLoader(new URL[]{new URL("file:/J:/lecture7/person.jar")}).loadClass("ru.sbt.bvv.lecture7.Person");
            }
        }catch(Exception e){
            e.printStackTrace();
        }*/
        try {
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("file:/J:/lecture7/person.jar")},null);
            Class<?> calcClazz = urlClassLoader.loadClass("ru.sbt.bvv.lecture7.CalculatorImpl");


            Calculator cl = new CalculatorImpl();
            cl.calc();

            cl=(Calculator)calcClazz.newInstance();
            cl.calc();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
