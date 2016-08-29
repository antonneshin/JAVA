package src.lesson2908;

import java.io.*;
import java.net.Socket;

/**
 * Created by Student on 29.08.2016.
 */
public class MyCkient3 {
    public static final String HOST = "localhost";
    public static final int PORT = 3333;
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST,PORT);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
//        bufferedWriter.write("privet \n");
//        bufferedWriter.flush();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(bufferedReader.readLine());

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String answer;
        while(true){
            if((answer=consoleReader.readLine())!= null){
                bufferedWriter.write(answer+"\n");
                bufferedWriter.flush();

                String fromServer = bufferedReader.readLine();
                if(fromServer.equals("you win!")){
                    System.out.println("you win, men!");
                    break;
                } else{
                    System.out.println("it's wrong answer");
                }
            }
        }
    }
}
