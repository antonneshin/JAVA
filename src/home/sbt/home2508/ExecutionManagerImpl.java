package src.home.sbt.home2508;

import java.util.Vector;

/**
 * Created by Пентагон on 25.08.2016.
 */
public class ExecutionManagerImpl implements ExecutionManager {
    private Vector<Thread> threads;
    private boolean endFlag;
    private Integer numOfThreads;
    public ExecutionManagerImpl(int cnt) throws Exception {
        if (cnt>0) {
            numOfThreads=cnt;
            threads = new Vector<>();
            for (int i = 0; i< numOfThreads; i++){
                Thread t = new Thread();
                t.start();
                threads.add(t);
            }
            endFlag = false;
        } else {
            throw new Exception("incorrect num of threads ");
        }
    }
    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        return null;
    }
}
