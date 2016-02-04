/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadExcerciseopg1;

/**
 *
 * @author pagh
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException
    {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        MyThread3 t3 = new MyThread3();
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(10000);
        t3.running = false;
        System.out.println("Nu er alle Threads startet and going!");
    }
    
}
