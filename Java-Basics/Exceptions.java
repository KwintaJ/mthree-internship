// custom exception class
class Lazy extends RuntimeException
{
    private String errMsg;

    Lazy(String errMsg)
    {
        this.errMsg = errMsg;
    }

    @Override
    public String getMessage()
    {
        return errMsg;
    }
}

class Server
{
    void start()
    {
        System.out.println("--started--");
        try
        {
            doTheThing();
        }
        catch(RuntimeException e)
        {
            System.out.println(e.getMessage());    
        }
    }
    void doTheThing() throws Lazy
    {
        System.out.println("----");
        throw new Lazy("i'm just not doing this");
    }
}

public class Exceptions
{
    public static void main(String args[])
    {
        int [] arr1 = {0, 1};

        try
        {
            // System.out.println(arr1[6]);

            try
            {
                int y = arr1[1] / arr1[0];
            }
            catch(ArithmeticException wrongCalculation)
            {
                System.out.println("illigal operation performed - inside block");
                System.out.println(arr1[6]);
            }
            
            // int x = arr1[1] / arr1[0];
        }
        catch(ArrayIndexOutOfBoundsException wrongArrIndex)
        {
            System.out.println("array wrong index - outside block");
        }
        catch(ArithmeticException wrongCalculation)
        {
            System.out.println("illigal operation performed  - outside block");
        }
        catch (Exception broad)
        {
            System.out.println("error");
        }
        finally
        {
            // this block is always executed, 
            // no matter exceptions or not
            System.out.println("finally");
        }

        System.out.println("");

        Server s = new Server();
        s.start();
    }
}