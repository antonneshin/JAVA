package src.lesson2507;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Student on 25.07.2016.
 */
public class FinallyTest {
    public static void main(String[] args) {
       // System.out.println(f());
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (Exception e){
                        System.out.println(e.toString());
                    }
                    System.out.println("I'm a thread");
                }
            }
        }).start();
        int i=1/0;

    }
    /*
    private static int f()
    {
        try
        {
            return 1;

            //throw new Exception();
        } catch (Exception e) {
            return 2;
        }finally {
            return 3;
        }
    }*/
}
