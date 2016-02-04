/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadExcercise1opg2;

/**
 *
 * @author pagh
 */
public class Thread1 extends Thread
{

    Even bob;

    public Thread1(Even even)
    {
        this.bob = even;
    }

    public void run()
    {
        for(int i = 0; i < 1000000; i++)
        {
            bob.next();
        }
        
    }

}
