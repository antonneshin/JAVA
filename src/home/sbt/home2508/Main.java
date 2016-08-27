package src.home.sbt.home2508;

import java.util.Vector;

/**
 * Created by Пентагон on 25.08.2016.
 */



public class Main {
    public static void main(String[] args) {
        ExecutionManager executionManager=null;
        try {
            executionManager = new ExecutionManagerImpl(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Vector<Runnable> runs=new Vector<>();
        for (int i=0;i<10;i++){
            Runnable r =new Runnable() {
                @Override
                public void run() {
                    System.out.println("---some work");
                }
            };
            runs.add(r);
        }
        Context context = executionManager.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(888);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("callback is in process...");
            }
        },runs);
        while(!context.isFinished()){}
        context.interrupt();
    }
}
