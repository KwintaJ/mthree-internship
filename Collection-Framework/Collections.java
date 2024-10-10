// Collections only works with objects (wrapper classes)
// Dynamic size
// To traverse use iterator

import java.util.*;

class Human
{
    private int age;
    String name;

    Human()
    {
        age = 0;
        name = "";
    }

    Human(int a, String n)
    {
        age = a;
        name = n;
    }

    int getAge()
    {
        return age;
    }

    @Override
    public String toString()
    {
        return name + " (" + this.age + ")";
    }
}

public class Collections
{
    static void printCollection(Collection x)
    {
        System.out.println(x); // toString is overriden
    }

    static String loopThrough(Collection x)
    {
        String out = "";
        for(Object i : x) // loops
        {
            out += i.toString();
        }
        return out;
    }

    static boolean hasNinCollection(Collection<Integer> x, Integer n)
    {
        Iterator it = x.iterator(); // iterator

        while(it.hasNext())
        {
            Object i = it.next();
            if(i.equals(n))
                return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        Stack<Integer> stack1 = new Stack<>();

        list1.add(10);
        list1.add(20);

        stack1.add(1);
        stack1.add(2);

        list2.add(20);
        list2.add(8);
        list2.add(11);
        list2.add(9);

        Collection[] arrOfCollections = new Collection[3];
        arrOfCollections[0] = list1;
        arrOfCollections[1] = stack1;
        arrOfCollections[2] = list2;


        for(Collection c : arrOfCollections)
        {
            printCollection(c);
        }

        System.out.println(loopThrough(list1));
        System.out.println(hasNinCollection(list1, 8));
        System.out.println(hasNinCollection(list2, 8));  

        ArrayList<Human> listOfHumans = new ArrayList<>();
        listOfHumans.add(new Human(10, "Josh"));  
        listOfHumans.add(new Human(1, "Ann"));  
        listOfHumans.add(new Human(45, "CJ"));  
        listOfHumans.add(new Human(12, "Pablo"));  
        listOfHumans.add(new Human(18, "Peter"));  
        listOfHumans.add(new Human(21, "Josh"));  

        System.out.println();
        printCollection(listOfHumans);

        listOfHumans.sort(Comparator.comparing(Human::getAge));
        printCollection(listOfHumans);

    }
}