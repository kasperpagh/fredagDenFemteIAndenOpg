/*
Svar på
 */
package ThreadExcercise1opg2;

/**
 *
 * @author pagh
 */
public class Hoved
{

    public static void main(String[] args) throws InterruptedException
    {
        //Begge tråde tilgår even.next(), derfor får en 2 og en anden 4.
        Even even = new Even();
        Thread1 t1 = new Thread1(even);
        Thread1 t2 = new Thread1(even);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        System.out.println("total værdi fra even: " + even.getN());
    }

}
