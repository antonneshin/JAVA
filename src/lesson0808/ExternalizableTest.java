package src.lesson0808;

import java.io.*;
import java.util.Date;

/**
 * Created by Student on 08.08.2016.
 */
class DateAndTime implements Externalizable{
    private int year;
    private int month;
    private int day;
    private int hours;
    private int minutes;
    private int seconds;

    @Override
    public String toString(){
        return "DateAndTime: \nyear"+year+"\nmonth="+month;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

    public DateAndTime(){
        year=1999;
        month=12;
        day=3;
        hours=4;
        minutes=12;
        seconds=34;
    }
}

public class ExternalizableTest {
    public static void main(String[] args){
        String fileName = "c:\\task\\dat.bin";
        DateAndTime dat=new DateAndTime();
//        try{
//            ObjectOutputStream fin=new ObjectOutputStream((new FileOutputStream(fileName)));
//            fin.writeObject(dat);
//            //System.out.println(dat);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        try{
            ObjectInputStream fin=new ObjectInputStream((new FileInputStream(fileName)));
            dat=(DateAndTime)fin.readObject();
            System.out.println(dat);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
