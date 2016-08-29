package src.lesson2908;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Student on 29.08.2016.
 */
public class MyServer2 {
    public static final int DEFAULT_PORT = 3333;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);//создали слушателя
        Socket accept = serverSocket.accept();//ловим соединение
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write((new Date()).toString()+" \n");
        bufferedWriter.flush();

        serverSocket.close();
        bufferedReader.close();
        bufferedWriter.close();
        outputStream.close();
        inputStream.close();
    }
}
