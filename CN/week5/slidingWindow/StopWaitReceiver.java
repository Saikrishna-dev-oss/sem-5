package slidingWindow;

import java.io.*;
import java.net.*;

public class StopWaitReceiver {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9999);
        Socket socket = server.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String frame;
        while ((frame = in.readLine()) != null && !frame.equals("exit")) {
            System.out.println("Frame " + frame + " was received");
            Thread.sleep(500);
            out.println("Received");
        }

        System.out.println("ALL FRAMES WERE RECEIVED SUCCESSFULLY");
        socket.close();
        server.close();
    }
}