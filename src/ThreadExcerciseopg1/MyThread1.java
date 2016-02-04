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
public class MyThread1 extends Thread
{
    private long bil = 0;
    public void run()
    {
       for(int i = 0; i < 1000000000; i++)
       {
           bil = bil + i;
       }
        System.out.println("The sum is: " + bil);
        System.out.println("THREAD 1 IS DONE");
    }
}
