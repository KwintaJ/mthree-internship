package toTest;

public class App
{
    public int logic(String s)
    {
        if(s.length() > 5)
            return -1;
        return 0;
    }

    public static void main(String[] args)
    {
        App a = new App();   
    }
}