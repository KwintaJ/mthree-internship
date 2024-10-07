class Server
{
    void start()
    {
        System.out.println("--started--");
        try
        {
            doTheThing();
        }
        catch(Exception e)
        {
            System.out.println("-can not do the thing-");    
        }
    }
    void doTheThing() throws Exception
    {
        System.out.println("----");
        throw new Exception("i can not do the thing");
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