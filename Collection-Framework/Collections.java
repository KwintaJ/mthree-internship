// Collections only works with objects (wrapper classes)
// Dynamic size
// To traverse use iterator

import java.util.*;

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

    static boolean has8inCollection(Collection<Integer> x)
    {
        Iterator it = x.iterator(); // iterator

        while(it.hasNext())
        {
            Object i = it.next();
            if(i.equals(8))
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

        list2.add(7);
        list2.add(8);
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
        System.out.println(has8inCollection(list1));
        System.out.println(has8inCollection(list2));         
    }
}