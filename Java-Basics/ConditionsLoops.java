public class ConditionsLoops
{
    static int magicNumber = 7;

    static void show1()
    {
        System.out.println("--1--");
    }

    static void show2()
    {
        System.out.println("--2--");
    }

    static void show3()
    {
        System.out.println("--3--");
    }

    public static void main(String[] args)
    {
        // ifElse();

        // nestedIfElse();

        // forLoop();

        advFor();

        // whileLoop();

        // doWhileLoop();
    }

    static void ifElse()
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
        System.out.println();
    }

    static void nestedIfElse()
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
        System.out.println();
    }
    
    static void forLoop()
    {
        for (int i = 0; i < magicNumber; i++)
        {
             show1();   
        }
        System.out.println();
    }

    static void advFor()
    {
        int[] numbers = {4, 5, 6, 0};
    
        // for each loop 
        for (int number: numbers)
        {
            System.out.println(number);
        }
    }

    static void whileLoop()
    {
        int i = 2 * magicNumber;
        while(i > 0)
        {
            show2();
            i--;
        }
        System.out.println();
    }
    
    static void doWhileLoop()
    {
        int i = 2 * magicNumber;
        do
        {
            show3();
            i++;
        }while(i < 20);
        System.out.println();
    }
    
}