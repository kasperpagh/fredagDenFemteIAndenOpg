/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadExcercise2Opg1;

import java.util.Arrays;

/**
 *
 * @author pagh
 */
public class ImageThreader extends Thread
{

    private String url;
    private int sum;
    private ImageGetter getter;
    private byte[] byteHolder = new byte[4096];
            
    public ImageThreader(String url)
    {
        getter = new ImageGetter();
        this.url = url;
    }

    
    public void run()
    {
        byteHolder = getter.getBytesFromUrl(url);
        
        
//   Hvis man selv vil se:)     System.out.println(Arrays.toString(byteHolder));
        for (byte c : byteHolder)
        {
            sum = sum+c;
        }
    }

    public int getSum()
    {
        return sum;
    }

}
