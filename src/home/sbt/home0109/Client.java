package src.home.sbt.home0109;

import java.io.*;
import java.net.Socket;

/**
 * Created by Пентагон on 01.09.2016.
 */
public class Client {
    public static final String HOST = "localhost";
    public static final int PORT = 3333;
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(HOST, PORT);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        String answer;
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {

            answer = consoleReader.readLine();
            bufferedWriter.write(answer + "\n");
            bufferedWriter.flush();
            if (answer.equals("exit"))
                break;


            //System.out.println("mes from chat: " + bufferedReader.readLine());
        }
        socket.close();
        bufferedReader.close();
        bufferedWriter.close();
        outputStream.close();
        inputStream.close();
    }
}
