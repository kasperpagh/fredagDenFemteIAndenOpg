/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadExcerciseopg1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pagh
 */
public class MyThread2 extends Thread
{
    public void run()
    {
        for(int i =0; i<=5; i++)
        {
            
            System.out.println("The current nr is: " + i);
            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(MyThread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("THREAD 2 IS DONE");
    }
}
