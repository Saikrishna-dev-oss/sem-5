package week7.csmaCD;

//CSMA/CD SERVER
import java.io.*;
import java.net.*;

public class Server
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("============ Server ===============");

            ServerSocket ss = new ServerSocket(6262);

            System.out.println("Waiting for connection...");

            Socket con = ss.accept();

            System.out.println("Connected");

            ObjectInputStream in =
                new ObjectInputStream(con.getInputStream());

            String msg = (String) in.readObject();

            System.out.println("Received message: " + msg);

            in.close();
            con.close();
            ss.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
