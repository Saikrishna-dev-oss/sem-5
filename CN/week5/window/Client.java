package window;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter window size (N): ");
        int windowSize = sc.nextInt();

        System.out.print("Enter total no. of frames: ");
        int totalFrames = sc.nextInt();

        int[] data = new int[totalFrames];
        for (int i = 0; i < totalFrames; i++) {
            System.out.print("Enter data for frame " + i + ": ");
            data[i] = sc.nextInt();
        }

        Socket socket = new Socket("localhost", 6262);
        // Timeout after 3.5 seconds if server ACK doesn't arrive
        socket.setSoTimeout(3500);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        int base = 0; // First unacknowledged frame

        while (base < totalFrames) {
            // 1. Send all frames within current window
            int sendUpTo = Math.min(base + windowSize, totalFrames);
            for (int i = base; i < sendUpTo; i++) {
                System.out.println("Sending frame: " + i + " [Data: " + data[i] + "]");
                dos.writeInt(i);
                dos.writeInt(data[i]);
            }
            System.out.println();

            // 2. Wait for ACKs
            try {
                while (base < sendUpTo) {
                    int ack = dis.readInt();
                    System.out.println("Acknowledgement of frame " + ack + " received.");
                    base = ack + 1; // Slide window forward
                }
                System.out.println();
            } catch (SocketTimeoutException e) {
                // 3. Go-Back-N triggered on timeout
                System.out.println("\nTimeout! No ACK received in 3.5s. Resending from frame: " + base + "\n");
            }
        }

        dos.writeInt(-1); // Signal server to exit
        System.out.println("All frames sent and acknowledged successfully!");

        socket.close();
        sc.close();
    }
}
