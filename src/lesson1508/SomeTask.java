package src.lesson1508;

import java.util.ArrayList;

/**
 * Created by Student on 15.08.2016.
 */
public class SomeTask implements Runnable{
    @Override
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<3;i++) {

            System.out.println(Thread.currentThread().getName()+" (("+i+")");
        }
    }

    public static void main(String[] args) {
        SomeTask st= new SomeTask();
       /* Thread t = new Thread(st);
        t.start();*/
        for (int i=0;i<5;i++) {
           new Thread(st).start();
        }
        st.run();
        System.out.println("End of main program");
        ArrayList<Thread> alt=new ArrayList<>();
        for(int i=0;i<10;i++){
            alt.add(new Thread(st));
            alt.get(i).start();
        }

    }
}
