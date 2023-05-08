import java.io.*;
import java.net.*;

/**
 * Very Simple client-server TCP one-way chat
 * to practice socket programming in java
 * reference : https://www.geeksforgeeks.org/socket-programming-in-java/
 */

public class Server{
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in =  null;

    public Server(int port){
        try {
            server = new ServerSocket(port);
            System.out.println("Server is up and running!");
            System.out.println("Server is waiting for the client to connect!");

            socket = server.accept();
            System.out.println("Client Connected!");

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            while (!line.equals("!exit")){
                try {
                    line = in.readUTF();
                    System.out.println(line);
                } catch (IOException i){
                    System.out.println(i);
                }
            }
            System.out.println("Cclosing connection");
            socket.close();
            in.close();
        } catch (IOException i){
            System.out.println(i);
        }
    }

    public static void main(String[] args){
        Server server = new Server(5001);
    }
}