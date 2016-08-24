package src.home.sbt.home2508;

/**
 * Created by Пентагон on 25.08.2016.
 */
public interface Context {
    int getCompletedTaskCount();

    int getFailedTaskCount();

    int getInterruptedTaskCount();

    void interrupt();

    boolean isFinished();
}

