/*
CREATE MULTI LEV INHRITANCE
 
EACH CLASS MUST HAVE 
 
I> 2 VARIABLES OF DIFF DATA TYPE 
II> 2 METHODS OF DIFF NAME REUTUN SOMETHING
III> 2 CONSTRUCTORS
 
 
NOTE -> INSIDE MAIN METHOD YOU ARE ALLOWED ONLY 1 LINER CODE
 
OUTPUT -> IT SHOULD PRINT TOTAL 18 LINES STARTING FROM GRAND PARENT CLASS TO
          CHILD CLASS
 
 
TRY TO USE ACCESS SPECIFIERS
*/

class GrandParent
{
    private int gpNum = 0;
    private String gpName = "GrandParent";

    GrandParent()
    {
        gpNum = 0;
        gpName = "GrandParent";
    }

    GrandParent(int n, String s)
    {
        gpNum = n;
        gpName = s;
    }

    String welcome()
    {
        System.out.println("number of " + gpName + " is " + this.showNumber());
        for(int i = 0; i < 4; i++)
            System.out.println(".");
        return gpName;
    }

    int showNumber()
    {
        return gpNum;
    }
}

class Parent extends GrandParent
{
    private int pNum;
    private String pName;

    Parent()
    {
        pNum = 0;
        pName = "Parent";
    }

    Parent(int n, String s)
    {
        super(n + 1, "parent-of-" + s);
        pNum = n;
        pName = s;
    }

    @Override
    String welcome()
    {
        GrandParent gp = new GrandParent(pNum + 1, "parent-of-" + pName);
        System.out.println(gp.welcome());
        System.out.println("number of " + pName + " is " + this.showNumber());
        for(int i = 0; i < 4; i++)
            System.out.println(".");
        return pName;
    }

    @Override
    int showNumber()
    {
        return pNum;
    }
}

class Child extends Parent
{
    private int cNum;
    private String cName;

    Child()
    {
        cNum = 0;
        cName = "Child";
    }

    Child(int n, String s)
    {
        super(n + 1, "parent-of-" + s);
        cNum = n;
        cName = s;
    }

    @Override
    String welcome()
    {
        Parent p = new Parent(cNum + 1, "parent-of-" + cName);
        System.out.println(p.welcome());
        System.out.println("number of " + cName + " is " + this.showNumber());
        for(int i = 0; i < 4; i++)
            System.out.println(".");
        return cName;
    }

    @Override
    int showNumber()
    {
        return cNum;
    }
}

public class TestTask
{
    public static void main(String[] args)
    {
        System.out.println(new Child(10, "J").welcome());
    }
}