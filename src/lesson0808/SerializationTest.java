package src.lesson0808;

import java.io.*;

/**
 * Created by Student on 08.08.2016.
 */

class Person implements Serializable{
    private String firstName;
    private int age;

    public Person() {
        this.firstName = "007";
        this.age=33;
        System.out.println("person");
    }
}

class Student implements Serializable {
    private String group;
    private int avgMark;
    //private String password;
    //if write TRANSIENT password doesn't go to file
    transient String password;

    final static long serialVersionUID = 0L;

    public Student() {
        group = "default";
        avgMark = 3;
        password = "slowWay";
        System.out.println("In Constructor");
    }

    @Override
    public String toString(){
        return "Student( group="+group+", avgMark="+avgMark;
    }

    public void writeObject(ObjectOutputStream out) throws IOException {
        avgMark=avgMark^0xFFFFFF;
        out.defaultWriteObject();
        out.writeLong(System.currentTimeMillis());
    }

    public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        avgMark=avgMark^0xFFFFFF;
        long value = in.readLong();
        System.out.println(value);
    }
}

public class SerializationTest{


    public static void main(String[] args) {
        Student student=new Student();

        //write object in file
        String fileName = "c:\\task\\student.bin";
        try{FileOutputStream fis = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fis);
        oos.writeObject(student);
        } catch (Exception e){
            e.printStackTrace();
        }

        //read object from file
//        String fileName = "c:\\task\\student.bin";
//        try{FileInputStream fis = new FileInputStream(fileName);
//            ObjectInputStream oos = new ObjectInputStream(fis);
//            System.out.println(student);
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        Person per=new Person();
//        String fileName1 = "c:\\task\\per.bin";
//        try{FileOutputStream fis1 = new FileOutputStream(fileName1);
//            ObjectOutputStream oos1 = new ObjectOutputStream(fis1);
//            oos1.writeObject(per);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
