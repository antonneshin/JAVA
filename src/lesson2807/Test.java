package src.lesson2807;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Student on 28.07.2016.
 */
public class Test {
    public static void main(String[] args) {
        /*
            C c = new C();
            //Arrays.asList(C.class.getDeclaredMethods()).forEach(System.out::println);
            try {
                A.class.getDeclaredMethod("pA", String.class);
            } catch (NoSuchMethodException e) {
                System.out.println("error - " + e.toString());
            }

            try {
                System.out.println(C.class.getDeclaredField("putA").toString());
            } catch (NoSuchFieldException e) {
                System.out.println("error - " + e.toString());
            }

            try {
                System.out.println("class = " + Object.class.getSuperclass());
            } catch (NullPointerException e) {
            }
            ;

            try {
                Method m = A.class.getMethod("pA", String.class);
                //m.setAccessible(true);
                m.invoke(B.class.newInstance(), "test");
            } catch (Exception e) {
                System.out.println("Error in getMethod 'pA'");
            }
            ;


            try {
                Field f = C.class.getDeclaredField("aC");
                f.setAccessible(true);
                C cc = new C();
                System.out.println(f.get(cc));
                f.set(cc, "stroka");
                Field f2 = C.class.getDeclaredField("aC");
                f2.setAccessible(true);
                C ccc = new C();
                System.out.println(f2.get(ccc));
                System.out.println(f.getType());
                f.set(C.class.newInstance(), "qwe");
            } catch (Exception e) {
                System.out.println("error type = " + e.toString());
            }
        */
        /*try{
            Field f=C.class.getDeclaredField("putA");
            f.setAccessible(true);
            if(f.isAnnotationPresent(ValidLength.class)){
                System.out.println("there is an annotation: "+ValidLength.class.getTypeName());
                ValidLength vLen=f.getAnnotation(ValidLength.class);
                if (vLen.value()!=((String)f.get(C.class.newInstance())).length()){
                    System.out.println("Attention! the length is incorrect");
                }
            }
            else{
                System.out.println("there is no annotation");
            }
        }catch (NoSuchFieldException e){
            System.out.println("err "+e.toString());
        } catch (Exception ie){
            System.out.println("ie = "+ie.toString());
        }*/

        List<String> list=new ArrayList<>();
        List<String> loggedList=(List<String>)Proxy.newProxyInstance(list.getClass().getClassLoader(),list.getClass().getInterfaces(), new InvocationHandlerImpl(list));
        loggedList.add("first");
        System.out.println("log[0]="+loggedList.get(0));
        System.out.println(loggedList.remove(0));
        System.out.println("size="+loggedList.size());

    }
}
