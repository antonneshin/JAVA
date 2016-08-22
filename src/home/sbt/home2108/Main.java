package src.home.sbt.home2108;

import java.util.Vector;

/**
 * Created by Пентагон on 21.08.2016.
 */
public class Main {
    public static Vector<Double> myTasks;
    public static void main(String[] args) {
        myTasks=new Vector<>();
        myTasks.add(10.0);
        myTasks.add(20.0);
        myTasks.add(30.0);
        myTasks.add(40.0);
        myTasks.add(50.0);
        int poolSize=2;
        Tasks t = new Tasks(myTasks);
        for (int i = 0;i<poolSize;i++){
            (new Thread(t)).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.addTask(100.0);
        t.addTask(90.0);
    }
}
