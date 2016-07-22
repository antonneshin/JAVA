package src.lesson2207;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Student on 22.07.2016.
 */
public class GenericTest {
    public static void main(String[] args)
    {
        List<String> strList=new ArrayList<>();
        A <List> a=new A<>();
        a.setParam1(new ArrayList<String>());
        A<String> aString=new A<>();
        aString.setParam1(new String("test"));
        //strList.add(new Integer(1));
        System.out.println(a.getType());
        System.out.println(aString.getType());

        //new B<T>(){};
        System.out.println(B.<Short>getType((new Short("10"))));

        A<? extends Number> aq=new A<>(new Integer(10));
        System.out.println("aq_type="+aq.getType());

        A<? extends B> aa=new A<>(new B());
        A aaa=aa.getParam1();

        List<? super Number> list1=new ArrayList<>();
        list1.add(new Integer(10));
        list1.add(new Float(101));

    }
}
