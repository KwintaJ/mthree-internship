import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalClass
{
    public static void main(String[] args)
    {
        BigDecimal bd1 = new BigDecimal("222333444000222.1234");
        BigDecimal bd2 = new BigDecimal("444666888000444.2468");
    
        System.out.println(bd1.add(bd2));
        System.out.println(bd2.subtract(bd1));
        System.out.println(bd2.divide(bd1));
        System.out.println(bd1.multiply(bd2));

        System.out.println(bd1.pow(2));

        System.out.println(bd2.setScale(2, RoundingMode.HALF_UP));
        System.out.println(bd2.setScale(2, RoundingMode.HALF_DOWN));
        System.out.println(bd1.setScale(2, RoundingMode.FLOOR));
        System.out.println(bd1.setScale(2, RoundingMode.CEILING));
    }
}