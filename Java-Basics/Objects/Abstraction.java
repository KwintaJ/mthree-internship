// abstraction -> data hiding -- abstract classes and interfaces
abstract class One
{
    abstract void doOne();

    void showOne()
    {
        System.out.println("show one in one");
    }
}

interface Two
{
    void doTwo();
}

class Three extends One implements Two
{
    @Override
    public void doOne()
    {
        System.out.println("do one in three");
    }

    @Override 
    public void doTwo()
    {
        System.out.println("do two in three");
    }
}

public class Abstraction
{
    public static void main(String[] args)
    {
        // can not create object of abstract class
        // One oneObj = new One();

        // can not create object of interface
        // Two twoObj = new Two();
        
        Three threeObj = new Three();
        threeObj.doOne();
        threeObj.showOne();
        threeObj.doTwo();
    }
}