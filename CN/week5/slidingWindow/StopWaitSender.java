package slidingWindow;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class StopWaitSender {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of frames to be sent:");
        int n = sc.nextInt();
        sc.close();

        Socket socket = new Socket("localhost", 9999);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        for (int i = 0; i < n; i++) {
            System.out.println("Frame no " + i + " is sent");
            out.println(i);

            String ack = in.readLine();
            if (ack != null) {
                System.out.println("Acknowledgement was Received from receiver");
                Thread.sleep(1000); // reduced wait time for faster testing
            }
        }

        out.println("exit");
        socket.close();
    }
}