package src.lesson2908;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by Student on 29.08.2016.
 */
public class MulticastServer {
    public static final int BUFFER_SIZE=256;
    public static final int PORT = 3333;
    public static final String MULTICAST_GROUP= "224.0.0.22";

    public static void main(String[] args) throws IOException {
        try(MulticastSocket socket=new MulticastSocket(PORT))
        {
            InetAddress mul
        }
    }
}
