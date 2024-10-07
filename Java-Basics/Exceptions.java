public class Exceptions
{
    public static void main(String args[])
    {
        int [] arr1 = {0, 1};

        try
        {
            // System.out.println(arr1[6]);
            int x = arr1[1] / arr1[0];
        }
        catch(ArrayIndexOutOfBoundsException wrongArrIndex)
        {
            System.out.println("array wrong index");
        }
        catch(ArithmeticException wrongCalculation)
        {
            System.out.println("illigal operation performed");
        }
        catch (Exception broad)
        {
            System.out.println("error");
        }
    }
}