package src.home.sbt.home0109;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Пентагон on 01.09.2016.
 */
public class Server{
    public static final int DEFAULT_PORT = 3333;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);//создали слушателя
        Socket accept = serverSocket.accept();//ловим соединение
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s;
        while (true){
            s= bufferedReader.readLine();
            if (s.equals("exit"))
                break;
            System.out.println("mes from client: "+s);
        }


        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write((new Date()).toString()+" - end of chating"+" \n");
        bufferedWriter.flush();

        serverSocket.close();
        bufferedReader.close();
        bufferedWriter.close();
        outputStream.close();
        inputStream.close();
    }
}
