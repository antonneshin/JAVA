package src.home.sbt.home1008;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Пентагон on 10.08.2016.
 */
class Message implements Serializable{
    String from;
    String to;
    String text;
    public Message(){
        from="unknown";
        to="unknown";
        text="unknown";
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getText() {
        return text;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String fileName="Server.bin";
        FileInputStream fis;
        ObjectInputStream ois;
        FileOutputStream fos;
        ObjectOutputStream oos;
        ArrayList<Message> server2;
        Message chat,m1;
        System.out.println("Enter command:\n Exit - 0\n read Chat - 1\n write in Chat - 2");
        Integer answer=in.nextInt();
        while (answer!=0){
            switch(answer){
                case 1:{
                    try{
                        fis=new FileInputStream(fileName);
                        ois=new ObjectInputStream(fis);
                        server2=(ArrayList<Message>)ois.readObject();
                        for (int i=0;i<server2.size();i++) {
                            chat=server2.get(i);
                            System.out.println(chat.getFrom()+" says to "+chat.getTo()+": \""+chat.getText()+"\"");
                        }
                    } catch (ClassNotFoundException|IOException e){
                        e.printStackTrace();
                    }
                    break;
                }
                case 2:{
                    try {
                        fis = new FileInputStream(fileName);
                        ois = new ObjectInputStream(fis);
                        server2 = (ArrayList<Message>) ois.readObject();
                    } catch (ClassNotFoundException|IOException e){
                        server2=new ArrayList<>();
                    }
                    in.nextLine();
                    m1=new Message();
                    System.out.print("From: ");
                    m1.setFrom(in.nextLine());
                    System.out.print("To: ");
                    m1.setTo(in.nextLine());
                    System.out.print("Text: ");
                    m1.setText(in.nextLine());
                    server2.add(m1);
                    try{
                        fos=new FileOutputStream(fileName);
                        oos=new ObjectOutputStream(fos);
                        oos.writeObject(server2);
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                }
            }
            System.out.println("Enter command:\n Exit - 0\n read Chat - 1\n write in Chat - 2");
            answer=in.nextInt();
        }
        in.close();
    }

}
