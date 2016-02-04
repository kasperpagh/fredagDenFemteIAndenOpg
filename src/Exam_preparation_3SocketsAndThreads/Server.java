package Exam_preparation_3SocketsAndThreads;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//SVAR PÅ OPG B. Der er et potentielt race problem med både countThing og count, da alle clientHandler tårde skriver til dne. har fixet med lock, alternativt kunne jeg have brugt
//volatile keyword, like so: "volatile int count;"







//Protocol INFO: først skal der sendes et usr type, enten "ting" eller "monitor" alt efter om man vil være en tælletingklient eller en monitorklient
//Der efter kan man skrive følgende som ting: "#guest" (tæller en guest op), "#stop" (lukker socket).
//Som monitor kan man skrive følgende: "#getGuestCount" (returnerer det totale antal gæster), "#getIndividualCounts" (giver id og individuelt antal for alle connectede tælleapparater,
//"#getThingCount" (giver antalet af pt. tilsluttede tællemaskiner).


public class Server
{

    ServerSocket ss;
    ServerSocket ssm;
    Socket s;
    String ip;
    int port;
    boolean running;
    int count;
    int thingCount;
    Lock lock = new ReentrantLock();
    int clientIds = 0;
    ArrayList<ClientHandler> clientList;
    int id;

    public void registerThing()
    {
        lock.lock();
        try
        {
            System.out.println("Der er ++ på things, antallet er nu: " + thingCount);
            thingCount++;
        } finally
        {
            lock.unlock();
        }
    }

    public void registerGuest()
    {
        lock.lock();
        try
        {
            count++;
            System.out.println("Der er ++ på guests, antallet er nu: " + count);
        } finally
        {
            lock.unlock();
        }
    }

    public int getGuestCount()
    {
        return count;
    }

    public int getThingCount()
    {
        return thingCount;
    }

    public void stopServer()
    {
        running = false;
    }

    public void startServer()
    {
        running = true;
        port = 8888;
        ip = "localhost";
        count = 0;
        thingCount = 0;
        clientList = new ArrayList();
        System.out.println("Er tændt og venter på usertype på port 8888");
        try
        {
            ss = new ServerSocket();
            ss.bind(new InetSocketAddress(ip, port));
            while (running)
            {
                s = ss.accept();
                //each counter thinghy is representet by a ClientHandler serverside
                ClientHandler ch = new ClientHandler(s, this, id);
                clientList.add(ch);
                id++;
                clientIds++;
                new Thread(ch).start();
            }
        } catch (IOException ex)
        {
            System.err.println("Fangede en IObandit i startServer");
        }
    }

    public ArrayList getIndividualCounts()
    {
        return clientList;
    }

    public static void main(String[] args)
    {
        new Server().startServer();
    }

}
