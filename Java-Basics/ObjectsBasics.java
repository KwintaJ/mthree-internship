public class ObjectsBasics
{
    static String constatS = "same"
    int num = 8;
    int varN;

    public static void main(String[] args)
    {
        System.out.println(new ObjectsBasics().num);

        ObjectsBasics obj1 = new ObjectsBasics();
        ObjectsBasics obj2 = new ObjectsBasics();



        System.out.println(new ObjectsBasics().num);
    }
}