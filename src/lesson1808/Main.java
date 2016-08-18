package src.lesson1808;

import java.util.Date;

/**
 * Created by Student on 18.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        //first
//        Account account = new Account(100);
//        int x=3;
//        for(int i=0;i<x;i++){
//            new Thread(account).start();
//        }

        //second
        /*Square square = new Square(2,3,4);
        Thread t1 = new Thread(square);
        Thread t2 = new Thread(square);
        t1.start();
        t2.start();*/

        //third
//        Test t = new Test();
//        Thread t1 = new Thread(t);
//        t1.start();
//        try {
//            Thread.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        t.end();
//        System.out.println("end of program");

        //imutable
        /*
        Date dat1= new Date();
        System.out.println(dat1);
        Man ivan = new Man("Ivan", dat1);
        System.out.println(ivan.getName()+" "+ivan.getDate());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ivan.getDate().setTime(new Date().getTime());
        dat1.setTime(new Date().getTime());
        System.out.println(dat1);

        System.out.println(ivan.getDate());
*/
//        //interrupt thread
//        Test t = new Test();
//        Thread tr = new Thread(t);
//        tr.start();
//        tr.interrupt();
//        System.out.println("end of interrupted");
        //wait and notify
        MonitorExample monitorExample=new MonitorExample();
        Thread tr = new Thread(monitorExample);
        tr.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        monitorExample.sendMessage("Hello");
    }
}
