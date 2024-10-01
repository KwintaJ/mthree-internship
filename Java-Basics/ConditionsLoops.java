public class ConditionsLoops
{
    public static void main(String[] args)
    {
        int magicNumber = 8;

        if(magicNumber == 0)
        {
            show();
        }
        else
        {
            show();
        }

        for (int i = 0; i < magicNumber; i++)
        {
            show();
        }
    }

    public static void show()
    {
        System.out.println("hi");
    }
}