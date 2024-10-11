class SmithFamily implements Runnable
{
    Camera c;

    SmithFamily(Camera c)
    {
        this.c = c;
    }

    @Override
    public void run()
    {
        c.zoomClickAndSave();
    }
}

class BrownFamily implements Runnable
{
    Camera c;

    BrownFamily(Camera c)
    {
        this.c = c;
    }

    @Override
    public void run()
    {
        c.zoomClickAndSave();    
    }
}

public class Camera
{
    /*synchronized static void click()
    {
        for(int i = 0; i < 7; i++)
            System.out.println(Thread.currentThread().getName() + " " + "clicks!");
    }*/

    void click()
    {
        synchronized(this)
        {
            for(int i = 0; i < 7; i++)
                System.out.println(Thread.currentThread().getName() + " " + "clicks!");
        }
    }

    void zoomClickAndSave()
    {
        System.out.println(Thread.currentThread().getName() + " " + "zoom");
    
        synchronized(this)
        {
            for(int i = 0; i < 3; i++)
                System.out.println(Thread.currentThread().getName() + " " + "clicks!");
        }

        System.out.println(Thread.currentThread().getName() + " " + "saves");
    }

    public static void main(String[] args)
    {
        Camera cam = new Camera();

        SmithFamily s = new SmithFamily(cam);
        BrownFamily b = new BrownFamily(cam);

        Thread t1 = new Thread(s);    
        Thread t2 = new Thread(b);    

        t1.start();
        t1.setName("Smith");
        t2.start();
        t2.setName("Brown");
    }
}