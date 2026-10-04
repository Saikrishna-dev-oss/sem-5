package week7.csmaCA;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        System.out.println("=== CSMA/CA Receiver ===");
        try (ServerSocket ss = new ServerSocket(6262)) {
            while (true) {
                System.out.println("Waiting for connection...");
                try (Socket con = ss.accept();
                     ObjectInputStream in = new ObjectInputStream(con.getInputStream())) {
                    
                    System.out.println("Connected");
                    String msg = (String) in.readObject();
                    System.out.println("Received: " + msg);
                    break; // Frame received successfully, exit demo
                } catch (EOFException e) {
                    // Ignore empty probe checks from channel sensing
                }
            }
        } catch (Exception e) {
            System.out.println("Server exception: " + e);
        }
    }
}