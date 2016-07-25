package src.lesson2507;



import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Student on 25.07.2016.
 */

class Parent {
    public void method() throws IOException{};
}
class Child extends Parent{
    @Override
    public void method() throws FileNotFoundException{};
    public void test (Parent a) throws IOException{
        a.method();
    }

    public static void main(String[] args) {
        Parent a=new Parent();
        Child b=new Child();
        Child ch=new Child();
        try {
            ch.test(a);
            ch.test(b);
        } catch (IOException e)
        {
            System.out.println(e.toString());
        }
    }
}
