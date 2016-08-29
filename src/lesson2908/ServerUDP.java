package src.lesson2908;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Student on 29.08.2016.
 */
public class ServerUDP {
    public static final int PORT = 3333;
    public static final String HOST="localhost";
    public static final int BUFFER_SIZE=256;

    public static void main(String[] args) throws IOException{
        try(DatagramSocket socket=new DatagramSocket(PORT)){
            byte[] buffer = new byte[BUFFER_SIZE];
            String command = "";
            do{
                DatagramPacket datagramPacket=new DatagramPacket(buffer,buffer.length);
                socket.receive(datagramPacket);
                command=new String(datagramPacket.getData(),0,datagramPacket.getLength());
                System.out.println(command);
            }while(!command.equals("exit"));
        }
    }
}
