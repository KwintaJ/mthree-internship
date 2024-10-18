import lombok.Getter;
import lombok.Setter;

public class Aha
{
    @Getter
    @Setter
    private int a;

    public static void main(String[] args)
    {
        Aha aha1 = new Aha();
        aha1.setA(6);
        System.out.println(aha1.getA());
    }   
}