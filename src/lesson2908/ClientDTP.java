package src.lesson2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by Student on 29.08.2016.
 */
public class ClientDTP {
    public static final String HOST = "localhost";
    public static final int PORT = 3333;

    public static void main(String[] args) throws UnknownHostException, IOException {
        InetAddress address = InetAddress.getByName(HOST);
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
                DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,PORT);
                socket.send(dp);
            }while(!line.equals("exit"));
        }
    }
}
