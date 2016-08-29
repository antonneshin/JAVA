package src.lesson2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by Student on 29.08.2016.
 */
public class MulticastClient {
    public static final String HOST = "localhost";
    public static final int PORT = 3333;

    public static void main(String[] args) throws UnknownHostException, IOException {
        InetAddress group = InetAddress.getByName("224.0.0.22");
        BufferedReader console=null;
        DatagramSocket socket=null;
        try {
            socket = new DatagramSocket();
            console = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
        {
            String line;
            do{
                System.out.println("Enter message: ");
                line = console.readLine();
                byte[] bytes = line.getBytes();
                DatagramPacket dp = new DatagramPacket(bytes,bytes.length,group,PORT);
                socket.send(dp);
            }while(!line.equals("exit"));
        }
    }
}
