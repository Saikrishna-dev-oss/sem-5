package week9;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String args[]) throws Exception {
        Socket socket = new Socket("127.0.0.1", 6262);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while (true) {
            System.out.print("Client : ");
            s = stdin.readLine();
            out.println(s);

            s = in.readLine();
            System.out.print("Server : " + s + "\n");

            if (s != null && s.equalsIgnoreCase("BYE")) {
                break;
            }
        }

        socket.close();
        in.close();
        out .close();
        stdin.close();
    }
}
