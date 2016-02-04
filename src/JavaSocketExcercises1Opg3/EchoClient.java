/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSocketExcercises1Opg3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author kaspe
 */
public class EchoClient extends Thread
{

    private Socket s;
    private PrintWriter pw;
    private Scanner scan;
    private Scanner iScan;
    private String ip;
    private int port;
    private String cmd;

    public void connect()
    {
        ip = "localhost";
        port = 4444;

        try
        {
            s = new Socket(ip, port);
            iScan = new Scanner(System.in);
            pw = new PrintWriter(s.getOutputStream(), true);
            scan = new Scanner(s.getInputStream());
            System.out.println("Clienten er på!");

            while (true)
            {
                if (iScan.hasNext())
                {
                    cmd = iScan.nextLine();
                    System.out.println(cmd);
                    pw.println(cmd);
                }
                if (scan.hasNext())
                {
                    System.out.println(scan.nextLine());
                }
            }
        } catch (IOException IOex)
        {
            System.err.println("der er llama i connect");
        }

    }

    public static void main(String[] args)
    {
        new EchoClient().connect();
    }

}
