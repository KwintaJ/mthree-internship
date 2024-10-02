// data wrapping -> encapsulation
public class ObjectsBasics
{
    static String constatS = "c";
    int num = 8;
    int varN;

    // constructors
    ObjectsBasics()
    {
        System.out.println("default constructor");
    }
    ObjectsBasics(String a)
    {
        System.out.println("parametrised constructor, parameter: " + a);
    }

    public static void main(String[] args)
    {
        //System.out.println(new ObjectsBasics().num);

        // static properties
        ObjectsBasics obj1 = new ObjectsBasics("name");
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

    // instance block
    {
        System.out.println("i2");
    }

    // static block
    static
    {
        System.out.println("s");
    }

    // static block
    static
    {
        System.out.println("s2");
    }
}