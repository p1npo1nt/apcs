package old;
import java.util.Scanner;

public class qs {

    public static void main(String[] args) {
        String[] A = getData();

        // Sorts A
        Qsort(A, 0, A.length-1);

        // Outputs A
        int i = 0;
        while(i < A.length) {
            System.out.println(A[i]);
            i++;
        }
    }

    public static void Qsort(String[] A, int lo, int hi) {

        // method which recurses partitions
        // precondition: A[lo], A[hi] are all strings and lo < hi
        // postcondition: A[n] < A[n+1] for all n; lo leq n leq hi
        // termination: terminates when subarrays have length 0 or 1

        if(lo < hi) {
            // k --- partition pt.
            int k = partition(A, lo, hi);

            Qsort(A, lo, k-1);
            Qsort(A, k+1, hi);
        }
    }

    public static String[] getData() {
        int i = 0;
        int maxsize = 1000;

        Scanner input = new Scanner(System.in);
        String[] data = new String[maxsize];

        // Determine proper size of the array based on file length
        int newSize = 0;

        while(input.hasNextLine() && i < maxsize) {
            String line = input.nextLine();

            if(line.isEmpty()) {
                break;
            }

            data[i] = line;
            i++;
            newSize++;
        }

        input.close();

        // Create a new array with the correct length
        String[] result = new String[newSize];
        for(int j = 0; j < newSize; j++) {
            result[j] = data[j];
        }

        return result;
    }

    // Lomuto partition method
    public static int partition(String[] A, int lo, int hi) {
        String pivot = A[hi];  // Choose the pivot as the last element
        int i = lo - 1;  // Index of smaller element
        int j = lo;

        while(j < hi) {
            // If the current element is less than or equal to the pivot
            // Iterate through list via the pointer j, once an element A[j] is found that is less than or equal to pivot
            // , swap that element with the element at A[i] and increment i
            
            if(A[j].compareTo(pivot) <= 0) {
                i++;
             
                // swap
                String temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            j++;
        }

        // Finally:
        // Swap the pivot element with the element at i+1
        String temp = A[i + 1];
        A[i + 1] = A[hi];
        A[hi] = temp;

        return i + 1;  // Return the partition point, this is where we divide the arraay into two subarrays
    }
}
