package src.home.sbt.taskChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

/**
 * Created by Пентагон on 04.09.2016.
 */
public class Server {
    private static final int PORT_NUMBER=3333;
    public static final int CLIENTS_COUNT=2;
    private ServerSocket serverSocket;
    private static final Semaphore semaphoreForClients = new Semaphore(CLIENTS_COUNT);
    private ConcurrentHashMap<ClientsConnections, String> clientsConnections = new ConcurrentHashMap<ClientsConnections, String>();

    public Server(){
        BufferedReader bufferedReader=null;
        try{
            serverSocket = new ServerSocket(PORT_NUMBER);
            System.out.println("Starting the server");
            while(true){
                Socket socket = serverSocket.accept();
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientName = bufferedReader.readLine();
                if (semaphoreForClients.tryAcquire()){
                    ClientsConnections newClient = new ClientsConnections(socket,clientName,semaphoreForClients);
                    clientsConnections.put(newClient,clientName);
                    newClient.start();
                } else{
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    bufferedWriter.write("can't connect you to the chat\n");
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeAll(){
        try{
            serverSocket.close();
            synchronized (clientsConnections){
                for(ClientsConnections cc : clientsConnections.keySet()){
                    cc.close();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private class ClientsConnections extends Thread{
        private Socket socket;
        private String clientName;
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;
        private Semaphore semaphore;

        public ClientsConnections(Socket paramSocket, String paramName, Semaphore paramSemaphore){
            socket = paramSocket;
            clientName = paramName;
            semaphore = paramSemaphore;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
                close();
            }
        }

        public void writeToClients(String message){
            try {
                for (ClientsConnections cc : clientsConnections.keySet()) {
                    cc.bufferedWriter.write(message + " \n");
                    cc.bufferedWriter.flush();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            try {
                writeToClients(clientName + " has entered to the chat");

                String str = "";

                while (true) {
                    str = bufferedReader.readLine();
                    if (str.equals("exit"))
                        break;
                    writeToClients(clientName + ": " + str);
                }

                writeToClients(clientName + " has leaved the chat");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }
        private void close(){
            try{
                bufferedWriter.close();
                bufferedReader.close();
                socket.close();
                clientsConnections.remove(this);
                semaphore.release();
                if(clientsConnections.size()==0){
                    Server.this.closeAll();
                    System.exit(0);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
