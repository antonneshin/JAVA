package src.home.sbt.home2508;

/**
 * Created by Пентагон on 25.08.2016.
 */
public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}

