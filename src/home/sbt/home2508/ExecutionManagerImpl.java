package src.home.sbt.home2508;

import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Пентагон on 25.08.2016.
 */
public class ExecutionManagerImpl implements ExecutionManager {
    private Vector<Thread> threads;
    private volatile Vector<Runnable> tasks;
    public volatile boolean endFlag;
    public volatile boolean interruptFlag;
    private Integer numOfThreads;
    public volatile Integer compleatedTaskCnt;
    public volatile Integer failedTaskCnt;
    public volatile Integer interruptedTaskCnt;
    public ExecutionManagerImpl(int cnt) throws Exception {
        if (cnt>0) {
            numOfThreads=cnt;
            threads = new Vector<>();
            tasks=null;
            endFlag = false;
            interruptFlag = false;
            compleatedTaskCnt=0;
            failedTaskCnt=0;
            interruptedTaskCnt=0;
        } else {
            throw new Exception("incorrect num of threads ");
        }
    }
    private class MyThread extends Thread{
        @Override
        public void run(){
                while(!interruptFlag && !endFlag){
                    if (tasks!=null){
                        synchronized (tasks) {
                            if ((tasks != null) && (!tasks.isEmpty())) {
                                Runnable r = tasks.firstElement();
                                try {
                                    r.run();
                                    tasks.remove(0);
                                    synchronized (compleatedTaskCnt) {
                                        compleatedTaskCnt += 1;
                                    }
                                } catch (Exception e) {
                                    synchronized (failedTaskCnt) {
                                        failedTaskCnt += 1;
                                    }
                                    e.printStackTrace();
                                }
                                System.out.println("Thread " + Thread.currentThread().getName() + " is working");
                            } else {
                                endFlag = tasks.isEmpty();
                                Thread.yield();
                                System.out.println("Thread " + Thread.currentThread().getName() + " waiting for smth");
                            }
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
    }
    @Override
    public Context execute(Runnable callback, Vector tasks) {
        //this.tasks.addAll(Arrays.asList(tasks));
        this.tasks=tasks;
        for (int i = 0; i< numOfThreads; i++){
            Thread t = new MyThread();
            t.start();
            threads.add(t);
        }
        Context context = new Context() {
            @Override
            public int getCompletedTaskCount() {
                return compleatedTaskCnt;
            }

            @Override
            public int getFailedTaskCount() {
                return failedTaskCnt;
            }

            @Override
            public int getInterruptedTaskCount() {
                return interruptedTaskCnt;
            }

            @Override
            public void interrupt() {
                interruptFlag=true;
                for (int i = 0; i< numOfThreads; i++){
                    threads.get(i).interrupt();
                }
            }

            @Override
            public boolean isFinished() {
                return endFlag;
            }
        };
        (new Thread(()->{
            while(!endFlag){
                Thread.yield();
            }
            if (endFlag){
                System.out.println("processing callback...");
                callback.run();
            }
        })).start();
        return context;
    }
}
