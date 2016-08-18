package src.lesson1808;


/**
 * Created by Student on 18.08.2016.
 */
public class Test implements Runnable{
    private boolean endFlag = false;
    public void end(){
       setEndFlag(true);
    }

    public synchronized boolean isEndFlag() {
        return endFlag;
    }

    public synchronized void setEndFlag(boolean endFlag) {
        this.endFlag = endFlag;
    }

    public void run(){
        System.out.println("Start run");
        while (!isEndFlag()){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException() ;

            }
            System.out.println("endFlag="+endFlag);
        }
    }
}
