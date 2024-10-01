public class ConditionsLoops
{
    public static int magicNumber = 8;

    public static void show1()
    {
        System.out.println("--1--");
    }

    public static void show2()
    {
        System.out.println("--2--");
    }

    public static void show3()
    {
        System.out.println("--3--");
    }

    public static void main(String[] args)
    {
        ifElse();

        nestedIfElse();

        forLoop();

        whileLoop();

        doWhileLoop();
    }

    public static void ifElse()
    {
        if(magicNumber == 7)
        {
            show1();
        }
        else if(magicNumber == 0)
        {
            show2();
        }
        else
        {
            show3();
        }

    }

    public static void nestedIfElse()
    {
        if(magicNumber % 2 == 0)
        {
            if(magicNumber > 10)
            {
                show1();
            }
            else
            {
                show2();
            }
        }
        else
        {
            show3();
        }
    }
    
    public static void forLoop()
    {
        for (int i = 0; i < magicNumber; i++)
        {
             show1();   
        }
    }

    public static void whileLoop()
    {
        int i = 2 * magicNumber;
        while(i > 0)
        {
            show2();
            i--;
        }
    }
    
    public static void doWhileLoop()
    {
        int i = 2 * magicNumber;
        do
        {
            show3();
        }while(i < 20);
    }
    
    
}