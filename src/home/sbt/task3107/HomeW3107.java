package src.home.sbt.task3107;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Пентагон on 31.07.2016.
 */
class A {
    public static final String nameA="nameA";
    public static final String secondNameA="secondNameA";
    public static final int age=10;
    public void showA(){};
}
class B extends A {
    private int heightB;
    private int widthB;

    public int getHeightB() {
        return heightB;
    }

    public int getWidthB() {
        return widthB;
    }

    public void showB(){};
    private void putB(){};
}
public class HomeW3107 {
    public static void showFirstTask(){
        System.out.println("FIRST TASK");
        System.out.println("______________________________");
        B b=new B();
        Class<?> c=b.getClass();
        while (c!=Object.class) {
            System.out.println("THIS IS " + c);
            System.out.println("HERE ARE ITS METHODS:");
            Arrays.asList(c.getDeclaredMethods()).forEach(System.out::println);
            c = c.getSuperclass();
        }
        System.out.println("______________________________");
    }
    public static void showSecondTask(){
        System.out.println("SECOND TASK");
        System.out.println("______________________________");
        B b=new B();
        Class<?> c=b.getClass();
        Method[] methods=c.getDeclaredMethods();
        for(int i=0;i<methods.length;i++)
        {
            if (methods[i].getName().indexOf("get")>=0)
            {
                System.out.println(methods[i].getName());
            }
        }
        System.out.println("______________________________");
    }
    public static void showThirdTask()
    {
        System.out.println("THIRD TASK");
        System.out.println("______________________________");
        Class<?> cA=A.class;
        Field[] fields=cA.getDeclaredFields();
        try{
            for (int i=0;i<fields.length;i++)
            {
                if (fields[i].getName()==fields[i].get(cA)) {
                    System.out.println("field \""+fields[i].getName()+"\" with value=" + fields[i].get(cA));
                }
            }
        }catch(IllegalAccessException e){
            System.out.println("catch error - "+e.getMessage());
        }
        System.out.println("______________________________");
    }
    public static void main(String[] args) {
        showFirstTask();
        showSecondTask();
        showThirdTask();
    }
}
