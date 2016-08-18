package src.lesson1808;

/**
 * Created by Student on 18.08.2016.
 */
public class MonitorExample implements Runnable{
    private String message;
    public void doMessage(){
        try {
            synchronized (this){
                while(message == null){
                    wait();
                    System.out.println(message);
                    this.message=null;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String mes){
        synchronized (this){
            this.message=mes;
            notify();
        }
    }

    @Override
    public void run() {
        doMessage();
    }
}
