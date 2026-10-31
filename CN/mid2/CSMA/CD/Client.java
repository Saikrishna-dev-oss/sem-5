import java.net.*;
import java.io.*;
import java.util.*;

class Client {
    public static void main(String[] args) throws Exception {
        Random r = new Random();

        for (int i = 1; i <= 5; i++) {
            System.out.println("\nAttempt: " + i);

            if (i < 3) {
                int R = r.nextInt(4);
                System.out.println("Collision detected!");
                System.out.println("Backoff time: " + R + " seconds");
                Thread.sleep(R * 1000);
            } else {
                try {
                    Socket s = new Socket("localhost", 5000);
                    PrintWriter out = new PrintWriter(
                        s.getOutputStream(), true);
                    out.println("CNLABS");
                    System.out.println("Message sent successfully");
                    s.close();
                } catch (Exception e) {
                    System.out.println("Server not running!");
                }
                break;
            }
        }
    }
}