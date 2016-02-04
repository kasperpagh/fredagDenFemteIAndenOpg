/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam_preparation_3SocketsAndThreads;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kaspe
 */
public class ClientHandler extends Thread
{

    Socket s;
    Server server;
    private Scanner scan;
    boolean running;
    boolean pendingId;
    boolean isMonitor;
    PrintWriter pw;
    int personalCount;
    int id;

    public ClientHandler(Socket s, Server server, int id)
    {
        this.server = server;
        this.s = s;
        this.id = id;
    }

    public void killHandler() throws IOException
    {
        running = false;
        s.close();
    }

    public boolean isMonitor()
    {
        return isMonitor;
    }

    @Override
    public void run()
    {
        try
        {
            pw = new PrintWriter(s.getOutputStream(), true);
            pendingId = true;
            while (pendingId)
            {
                scan = new Scanner(s.getInputStream());
                String line = scan.nextLine();

                if (line.equals("ting"))
                {
                    System.out.println(this.toString() + " er en counter thinghy");
                    server.registerThing();
                    pendingId = false;
                    isMonitor = false;
                }
                if (line.equals("monitor"))
                {
                    System.out.println(this.toString() + " Der er nu en monitor klient sluttet til!");
                    pendingId = false;
                    isMonitor = true;
                }
            }

            personalCount = 0;
            running = true;
            while (running)
            {
                String line;
                line = scan.nextLine();
                if (line.equals("#guest"))
                {
                    personalCount++;
                    System.out.println("Der er gået " + personalCount + " mennesker igennem denne tælleting!");
                    server.registerGuest();
                    pw.println("Din count er registreret");
                }
                if (line.equals("#stop"))
                {
                    killHandler();
                }
                if (line.equals("#getGuestCount") && isMonitor)
                {
                    server.getGuestCount();
                    pw.println("Det totale antal af gæster er: " + server.getGuestCount());
                }

                if (line.equals("#getIndividualCounts") && isMonitor)
                {
                    ArrayList<ClientHandler> bob = server.getIndividualCounts();
                    pw.println("her er de enkelte tings count: ");
                    for (ClientHandler ch : bob)
                    {
                        
                        pw.println("ID: " + ch.id + ", Antal: " +ch.personalCount);
                    }
                    pw.println();
                }

                if (line.equals("#getThingCount") && isMonitor)
                {
                    System.out.println("Der blev bedt om thingcount: " + server.getThingCount());
                    server.getGuestCount();
                    pw.println("Det totale antal af tælle thinghys er: " + server.getThingCount());
                }
            }

        } catch (IOException ex)
        {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
