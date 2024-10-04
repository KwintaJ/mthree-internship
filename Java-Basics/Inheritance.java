//super keyword
class Parent
{
    int num = 100;

    Parent()
    {
        System.out.println("P");
    }

    String sayHi()
    {
        return "No";
    }
}

class Child extends Parent
{
    int num = 200;

    @Override
    String sayHi()
    {
        return "Hi";
    }
}

public class Inheritance
{
    public static void main(String[] args)
    {
        //upcasting
        Child o = new Child();
        System.out.println(o.num);
        System.out.println(o.sayHi());
    }
}