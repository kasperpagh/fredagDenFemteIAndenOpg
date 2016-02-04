/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadExcercise1opg1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pagh
 */
public class MyThread3 extends Thread
{
    private int bob = 10;
    
    public boolean running = true;
    public void run()
    {
        
        while(running)
        {
            System.out.println("Her fra t3 er tallet: " + bob);
            bob++;
            try
            {                
                Thread.sleep(3000);
                
            } catch (InterruptedException ex)
            {
                Logger.getLogger(MyThread3.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        System.out.println("T3 er done");
    }
}
