/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExercisesThreads1Opg6;

import javax.swing.JLabel;

/**
 *
 * @author kaspe
 */
public class Exercise6 extends Thread
{
    JLabel bob;
    public Exercise6(JLabel j1)
    {
        bob = j1;
    }
    
    
   
    public void run()
    {
        for (int i = 20; i > 0; i--)
        {
            bob.setText("remains: " + i);
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {

            }
        }
    }
}
