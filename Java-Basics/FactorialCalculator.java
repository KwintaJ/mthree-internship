import java.util.Scanner; 

public class FactorialCalculator
{
    int num;

    FactorialCalculator(int n)
    {
        num = n; 
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int inpNum = scan.nextInt();
        int outNum = new FactorialCalculator(inpNum).calculate();
        System.out.println(outNum);
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
