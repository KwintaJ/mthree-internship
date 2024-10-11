public class Question2
{
    int[] array = {39, 1, -500, 3, 12, 146, 8, 0};

    String printArray()
    {
        String out = "";
        for(int x : array)
        {
            out += x + " ";
        }
        return out;
    }

    void sortArray()
    {
        // simple bubble sort
        for(int i = 0; i < array.length; i++)
        {
            for(int j = i; j < array.length; j++)
            {
                // swaping a pair of elements if not ascending
                if(array[i] > array[j])
                {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Question2 q = new Question2();

        System.out.println("Starting array:");
        System.out.println(q.printArray());
        System.out.println();

        q.sortArray();
        System.out.println("Array after sorting:");
        System.out.println(q.printArray());
    }
}