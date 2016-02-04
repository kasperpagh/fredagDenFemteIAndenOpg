package JavaSocketExcercises1Opg3;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author kaspe
 */
public class EchoServer
{

    ServerSocket ss;
    Socket s;
    private String ip = "localhost";
    private int port = 4444;
    private OutputStream os;
    private PrintWriter pw;
    private Scanner scan;

    public void startServer()
    {
        try
        {
            ss = new ServerSocket();
            ss.bind(new InetSocketAddress(ip, port));

            System.out.println("Server er gogo og lytter på port 4444");

            while (true)
            {
                s = ss.accept();
                clientHandler(s);
                // opg 1 ///////////////////////
//            os = s.getOutputStream();
//            pw = new PrintWriter(os, true);
//            pw.println(new Date().toString());
                // opg 1 slut //////////////

            }
        } catch (IOException e)
        {
            System.err.println("bob i connect");
        }
    }

    public String getDate()
    {
        return new Date().toString();
    }

    public static void main(String[] args)
    {
        new EchoServer().startServer();
    }

    public void clientHandler(Socket s) throws IOException
    {
        boolean running = true;
        scan = new Scanner(s.getInputStream());
        pw = new PrintWriter(s.getOutputStream(), true);

        while (running)
        {
            System.out.println("i loop");

            String line = scan.nextLine();

            System.out.println("her er linjen på scan: " + line);
            switch (line)
            {
                case "UPPER#Hello World":
                    pw.println("HELLO WORLD");
                    break;
                case "LOWER#Hello World":
                    pw.println("hello world");
                    break;
                case "REVERSE#abcd":
                    pw.println("Dcba");
                    break;
                case "TRANSLATE#hund":
                    pw.println("dog");
                    break;
                case "Stop#":
                    s.close();
                    System.out.println("er socket lukket? " + s.isClosed());
                    break;
                case "#dato":
                    pw.println(getDate());
                    break;
            }

        }

    }

}
