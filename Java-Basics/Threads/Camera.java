class SmithFamily implements Runnable
{
    @Override
    public void run()
    {
        Camera.click();
    }
}

class BrownFamily implements Runnable
{
    @Override
    public void run()
    {
        Camera.click();    
    }
}

public class Camera
{
    synchronized static void click()
    {
        for(int i = 0; i < 7; i++)
            System.out.println(Thread.currentThread().getName() + " " + "clicks!");
    }

    public static void main(String[] args)
    {
        SmithFamily s = new SmithFamily();
        BrownFamily b = new BrownFamily();

        Thread t1 = new Thread(s);    
        Thread t2 = new Thread(b);    

        t1.start();
        t1.setName("Smith");
        t2.start();
        t2.setName("Brown");
    }
}