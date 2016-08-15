package src.lesson1508;

/**
 * Created by Student on 15.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        SomeTask st1= new SomeTask();
        /*Thread t1 = new Thread(st1);
        t1.setPriority(Thread.MIN_PRIORITY);

        Thread t2 = new Thread(st1);
        t2.setPriority(Thread.NORM_PRIORITY);

        Thread t3 = new Thread(st1);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t3.start();
        t2.start();
        */
        Thread dt = new Thread(st1);
        dt.start();
        System.out.println("1: "+dt.isAlive());
        try{
            dt.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("END!!!");
        System.out.println("2: "+dt.isAlive());

      /*  dt.setDaemon(true);
        dt.start();
        System.out.println("end!!!");
*/

//        SomeThread st=new SomeThread();
//        st.start();
//        System.out.println("end of prog");
//
//        new Thread(new Runnable() {
//            public void run() {
//                System.out.println("it's me");
//                try {
//                    Thread.sleep(5000);
//                    System.out.println("I'm not sleeping");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
    }
}
