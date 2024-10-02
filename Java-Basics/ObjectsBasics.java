public class ObjectsBasics
{
    static String constatS = "c";
    int num = 8;
    int varN;

    public static void main(String[] args)
    {
        //System.out.println(new ObjectsBasics().num);

        // static properties
        ObjectsBasics obj1 = new ObjectsBasics();
        ObjectsBasics obj2 = new ObjectsBasics();
        obj1.varN = 1;
        obj2.varN = 2;

        obj1.show();
        obj2.show();
    }

    void show()
    {
        System.out.println(constatS + varN);
    }

    // instance block
    {
        System.out.println("i");
    }

    // static block
    static
    {
        System.out.println("s");
    }
}