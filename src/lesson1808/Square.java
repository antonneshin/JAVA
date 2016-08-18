package src.lesson1808;

/**
 * Created by Student on 18.08.2016.
 */
public class Square implements Runnable {
    private final Object lockWidth = new Object();
    private final Object lockLocation = new Object();
    private int width;
    private int x;
    private int y;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        synchronized (lockWidth) {
            this.width = width;
        }
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public Square(int width, int x, int y) {
        this.width = width;
        this.x = x;
        this.y = y;
    }



    public void changeLocation(int xx, int yy){
        System.out.println("start change "+Thread.currentThread().getName());
        synchronized (lockLocation) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.x = xx;
            this.y = yy;
        }
        System.out.println("Changed "+Thread.currentThread().getName());
    }

    @Override
    public  void run(){
        changeLocation(2,3);
    }
}
