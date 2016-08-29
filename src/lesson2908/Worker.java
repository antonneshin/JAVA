package src.lesson2908;

import java.io.*;
import java.net.Socket;
import java.util.Random;

/**
 * Created by Student on 29.08.2016.
 */
public class Worker implements Runnable {
    private Socket socket;
    public Worker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        int secretNumber = new Random().nextInt(9);
        try {
            inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

            bufferedWriter.write("try guess \n");
            bufferedWriter.flush();

            String answer;
            while(true){
                if((answer=bufferedReader.readLine())!=null){
                    if(secretNumber == Integer.parseInt(answer)){
                        System.out.println("you win!");
                        bufferedWriter.write("you win! answer = "+answer+"\n");
                        bufferedWriter.flush();
                        break;
                    }
                }
            }

            socket.close();
            bufferedReader.close();
            bufferedWriter.close();
            outputStream.close();
            inputStream.close();



        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
