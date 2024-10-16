public class Wrappers
{
    public static void main(String[] args)
    {
        // Integer a = new Integer; // this is deprecated
        Integer a = 10; // built-in class auto-boxing
        int b = a; // auto-unboxing
        System.out.println(a); // toString is already overriden        
    }
}