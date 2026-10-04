package week7.csmaCA;

import java.io.*;
import java.net.*;
import java.util.Random;

public class Client {
    private static final Random rand = new Random();

    public static void main(String[] args) throws Exception {
        System.out.println("=== CSMA/CA Sender ===");

        for (int k = 1; k <= 15; k++) {
            System.out.println("\nAttempt " + k + ": Sensing channel...");

            // 1. Wait until channel is idle
            while (!isChannelIdle()) {
                Thread.sleep(500);
            }

            // 2. Wait IFS and verify idle
            System.out.println("Channel idle. Waiting IFS (1.5s)...");
            Thread.sleep(1500);
            if (!isChannelIdle()) {
                System.out.println("Channel became busy during IFS. Retrying...");
                continue;
            }

            // 3. Binary Exponential Backoff: R in [0, 2^k - 1]
            int maxSlots = (int) Math.pow(2, Math.min(k, 10)); // Cap window at 1024
            int r = rand.nextInt(maxSlots);
            System.out.println("Backing off for " + r + " slots (" + (r * 100) + "ms)...");
            Thread.sleep(r * 100L);

            // 4. Transmit Frame
            try (Socket s = new Socket("localhost", 6262);
                 ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream())) {
                
                out.writeObject("Frame from Client");
                out.flush();
                System.out.println("Frame sent successfully. ACK received!");
                return;
            } catch (IOException e) {
                System.out.println("Collision or receiver offline. Retrying...");
            }
        }
        System.out.println("Transmission failed after 15 attempts.");
    }

    // Simulates an 85% probability that the wireless medium is clear
    static boolean isChannelIdle() {
        return rand.nextInt(100) < 85;
    }
}