package src.home.sbt.home2508;

import java.util.Vector;

/**
 * Created by Пентагон on 25.08.2016.
 */
public interface ExecutionManager {
    Context execute(Runnable callback, Vector tasks);
}

