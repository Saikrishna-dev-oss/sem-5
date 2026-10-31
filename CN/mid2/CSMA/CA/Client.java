import java.net.*;
import java.io.*;
import java.util.*;

class Client {
    public static void main(String[] args) throws Exception {
        Random r = new Random();

        System.out.println("Checking channel...");
        Thread.sleep(1000); // IFS

        int R = r.nextInt(4);
        System.out.println("Backoff: " + R);
        Thread.sleep(R * 1000);

        Socket s = new Socket("localhost", 5001);
        PrintWriter out = new PrintWriter(
            s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));

        out.println("CNLABS");
        System.out.println("Message sent");

        System.out.println("ACK: " + in.readLine());
        s.close();
    }
}