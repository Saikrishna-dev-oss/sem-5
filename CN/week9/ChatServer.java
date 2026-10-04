package week9;

import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(2000);
        Socket sk = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        PrintStream out = new PrintStream(sk.getOutputStream());
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
        sk.close();
        in.close();
        out.close();
        stdin.close();
    }
}