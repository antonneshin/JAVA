package src.home.sbt.home2108;

import java.util.Vector;

/**
 * Created by Пентагон on 21.08.2016.
 */


public class Tasks implements Runnable{
    private final Vector<Double> myTasks;
    public void addTask(Double e){
        synchronized (myTasks){
            myTasks.add(e);
            myTasks.notifyAll();
        }
    }
    public Tasks(Vector vals){
        myTasks=vals;
    }
    public Double countYearProfit(Double percent, Double vault){
        Double sum=vault;
        for(int i=0;i<12;i++){
            sum+=sum*percent/100;
        }
        return 1.0*Math.round(sum);
    }

    @Override
    public void run() {
        int i=0;
        System.out.println(Thread.currentThread().getName()+" waiting for taks...");
        while(true) {
            synchronized (myTasks) {
                if (!myTasks.isEmpty()) {
                    Double percent = 7.0;//1.0*Math.round(Math.random() * 100);
                    System.out.println("value=" + myTasks.firstElement() + " percent=" + percent + " res=" + countYearProfit(percent, myTasks.firstElement()));
                    myTasks.remove(0);
                    System.out.println("...was counted by " + Thread.currentThread().getName());
                    i=0;
                } else
                {
                    try {
                        myTasks.wait(1000);
                        i++;
                        if (i==10)
                            return;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
