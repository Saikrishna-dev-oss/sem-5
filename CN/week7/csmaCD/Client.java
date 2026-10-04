package week7.csmaCD;
import java.io.*;
import java.net.*;
import java.util.Random;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("============ Client 1 ===============");
        Random rand = new Random();

        for (int i = 1; i <= 15; i++) {
            System.out.println("\nAttempt : " + i);

            if (send("CNLABs")) {
                System.out.println("Transmission successful");
                break;
            }

            int k = Math.min(i, 10);
            int r = rand.nextInt(1 << k); // [0, 2^k - 1]
            int tb = r * 2000;

            System.out.println("Selected Random number : " + r);
            System.out.println("Waiting for next attempt with backoff time: " + (tb / 1000.0) + " seconds");
            Thread.sleep(tb);
        }
    }

    static boolean send(String msg) {
        try (Socket soc = new Socket("localhost", 6262);
             ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream())) {
            out.writeObject(msg);
            out.flush();
            System.out.println("Message sent: " + msg);
            return true;
        } catch (Exception e) {
            System.out.println("Collision occurred");
            return false;
        }
    }
}