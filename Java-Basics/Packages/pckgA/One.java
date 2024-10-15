package pckgA;

import pckgB.Two;

public class One
{
    public void showOne()
    {
        System.out.println("1");
        
        Two t = new Two();
        t.showTwo();
    }
}
