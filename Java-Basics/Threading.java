// Runnable vs Thread
// Runnable - interface, Thread - class
// Runnable - abstract run() and no start(), 
// Thread - run(), start()

class Task1 implements Runnable
{
    @Override
    public void run()
    {
        /*try
        {
            Thread.sleep(10);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }*/

        for(int i = 0; i < 10; i++)
            System.out.println("(1, " + i + ")");
    }
}

class Task2 extends Thread
{
    @Override
    public void run()
    {

        for(int i = 0; i < 10; i++)
            System.out.println("    (2, " + i + ")");
    }
}

public class Threading
{    
    public static void main(String[] args)
    {
        Task1 taskA = new Task1();
        Task2 taskB = new Task2();

        Thread t1 = new Thread(taskA);
        Thread t2 = new Thread(taskB);

        // t1.run();
        t1.start();
        // t2.run();
        t2.start();
    }
}