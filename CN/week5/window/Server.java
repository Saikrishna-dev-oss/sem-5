package window;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6262);
        System.out.println("Server established. Waiting for client...");

        Socket client = server.accept();
        System.out.println("Client connected.");

        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        int expectedFrame = 0;
        boolean simulateError = true; // Simulates one packet drop

        while (true) {
            int frameId = dis.readInt();
            if (frameId == -1) break; // Client finished

            int data = dis.readInt();

            if (frameId == expectedFrame) {
                // Simulate a dropped frame/ACK on frame 2 (once)
                if (expectedFrame == 2 && simulateError) {
                    System.out.println("Frame " + frameId + " received but simulated ERROR. ACK discarded.\n");
                    simulateError = false;
                    continue; 
                }

                System.out.println("Frame " + frameId + " received successfully with Data: " + data);
                dos.writeInt(expectedFrame); // Send cumulative ACK
                System.out.println("ACK " + expectedFrame + " sent.\n");
                expectedFrame++;
            } else {
                System.out.println("Frame " + frameId + " discarded (Out of order). Expected: " + expectedFrame + "\n");
            }
        }

        System.out.println("All data received. Server exiting.");
        client.close();
        server.close();
    }
}