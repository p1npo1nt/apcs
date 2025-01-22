import java.util.Scanner;

public class stack3
{

    static int comps = 0;
    static int calls = 0;
    static List<Integer> stack = new List<Integer>();
    final static int maxsize = 1000;

    public static void main(String args[])
    {
        String[] data = getData();
        qs(data);
        printLines(data);
    }

    // Prints each element in the sorted array on a new line
    public static void printLines(String[] data)
    {
        for(int count = 0; count < data.length; count++)
        {
            System.out.println(data[count]);
        }
        System.out.println(comps);
        System.out.println(calls);
    }
     
    // Reads data from standard input and returns it as a string array
    public static String[] getData()
    {
        // Create a Scanner to read each line of input
        Scanner stdin = new Scanner(System.in);
        String[] s = new String[maxsize];
        int i;

        // Store each line of input in the array `s` up to the max size
        for (i = 0; i < maxsize && stdin.hasNextLine(); i++)
        {
            s[i] = stdin.nextLine();
        }

        // Copy all data to a new array with the actual size of the input
        String[] data = new String[i];
        for(int j = 0; j < data.length; j++)
        {
            data[j] = s[j];
        }
        return data;
    }

    // Calls the quicksort function on the array
    public static void qs(String[] s)
    {
        quicksort(s, 0, s.length - 1);
    }

    // Sorts the array using quicksort with Lomuto's partition scheme
    public static void quicksort(String[] s, int low, int high)
    {
        calls++;
        /* QUICKSORT
            Purpose: Quicksort method that recurses and does Lomuto partitioning
            Precondition: All elements in the String array are non-null, and valid strings
            Postcondition: All elements are sorted in alphabetic order
            Termination: Terminates when section of array being processed only has 1 or fewer elements
            Recursion:
                Array partitioned by selecting a pivot (s[low])
                Rearranges elements such that:
                    - Elements smaller than or equal to the pivot are on the left
                    - Elements greater than the pivot are on the right
                After partitioning, two recursive calls are made:
                    - quicksort(s, low, p - 1) to sort the left partition: elements less than the pivot
                    - quicksort(s, p + 1, high) to sort the right partition: elements greater than the pivot
        */

        // Base case: If low < high, then multiple elements need sorting
        stack.push(low);
        stack.push(high);
        while(!stack.isEmpty())
        {
            // PARTITION
            // Initialize
            high = stack.pop();
            low = stack.pop();

            if(low < high)
            {
                int p = low;
                // Loop through the array to organize elements around the pivot
                for(int i = low; i <= high; i++)
                {
                    // If the current element is smaller than the pivot, swap with `p` and increment `p`
                    comps++;
                    if(s[i].compareTo(s[high]) < 0)
                    {
                        //swap so that smaller elements are placed on the left of the pivot
                        swap(s, p, i);
                        p++;
                    }
                }

                // Place pivot element in its correct sorted position
                swap(s, p, high);
                

                if(high > p + 1)
                {
                    stack.push(p + 1);
                    stack.push(high);
                }
                if(low < p - 1)
                {
                    stack.push(low);
                    stack.push(p - 1);
                }
            }
        }
    }

    // Swaps two elements in the array `s` at indices `a` and `b`
    public static void swap(String[] s, int a, int b)
    {
        String temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }
}