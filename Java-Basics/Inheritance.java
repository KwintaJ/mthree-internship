class Parent
{
    int num = 100;
}

class Child extends Parent
{
    int num = 200;
}

public class Inheritance
{
    public static void main(String[] args)
    {
        Parent o = new Child();
        System.out.println(o.num);
    }
}