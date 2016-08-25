package src.lesson2508.Lacth;

/**
 * Created by Student on 25.08.2016.
 */
public class LacthExample implements Runnable {
    @Override
    public void run() {
        try{
            System.out.println("before startGate.await()");
            startGate.await();
            System.out.println("after startGate.await()");
            try{
                System.out.println("current state"+emdGate.getCount());
            }
        }
    }
}
