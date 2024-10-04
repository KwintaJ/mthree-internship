import java.util.Scanner; 

class Factorial
{
    int num;

    Factorial(int n)
    {
        num = n; 
    }

    int calculate()
    {
        int out = 1;

        for(int i = 1; i <= num; i++)
        {
            out *= i;
        }

        return out;
    }
}

public class FactorialCalculator
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int inpNum = scan.nextInt();
        System.out.println(new Factorial(inpNum).calculate());
    }
}