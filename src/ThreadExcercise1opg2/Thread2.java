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
public class Thread2 extends Thread
{

    Even bob;

    public Thread2(Even even)
    {
        this.bob = even;
    }

    public void run()
    {
        System.out.println("Her er fra t2: " + bob.next());
    }
}
