package src.lesson1808;

/**
 * Created by Student on 18.08.2016.
 */
public class Account implements Runnable {
    private final Object myLock = new Object();

    private int saldo;

    public Account(int val) {
        saldo = val;
    }

    public int getSaldo() {
        return saldo;
    }

    public void decreaseSaldo(int sum){
        System.out.println("Try decrease saldo");
        synchronized(myLock) {
            if (saldo - sum < 0) {
                System.out.print("saldo = " + saldo + "  thread=" + Thread.currentThread().getName() + "   ");
                System.out.println("Overdraft not avialable");
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("saldo = " + saldo + "  thread=" + Thread.currentThread().getName());
                saldo -= sum;
            }
        }
//        Object o =new Object();
//        o.notify();
    }

    @Override
    public void run(){
        int x=12;
        for (int i=0;i<x;i++){
            decreaseSaldo(10);
            if (getSaldo()<0){
                throw new RuntimeException("Current account orverdrafted");
            }
        }
    }
}
