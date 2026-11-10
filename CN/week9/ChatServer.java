package week9;

import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(6262);
        Socket socket = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while (true) {
            s = in.readLine();
            if (s != null && s.equalsIgnoreCase("BYE")) {
                out.println("BYE");
                break;
            }

            System.out.print("Client : " + s + "\n");
            System.out.print("Server : ");
            s = stdin.readLine();
            out.println(s);
        }

        ss.close();
        socket.close();
        in.close();
        out.close();
        stdin.close();
    }
}