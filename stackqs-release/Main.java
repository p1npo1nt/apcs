import java.util.*;

public class Main {

    final static int maxsize = 1000;

    public static void main(String args[]) {
        String[] data = getData();
        quicksort(data);
        print(data);
    }
    

    // Reads data from standard input and returns it as a string array
    public static String[] getData() {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        String[] temp = new String[maxsize];
        int i;

        for (i = 0; i < maxsize && input.hasNextLine(); i++) {
            temp[i] = input.nextLine();
        }

        input.close();

        // copy input data to a properly sized array
        String[] data = new String[i];
        System.arraycopy(temp, 0, data, 0, i);
        return data;
    }

    // returns index of the pivot in its final place
    public static int partition(String[] s, int l, int h) {
        int p = l;
        
        for (int i = l; i <= h; i++) {
            // swap s.t. smaller elements are placed on the left of the pivot
            if (s[i].compareTo(s[h]) < 0) {
                swap(s, p, i);
                p++;
            }
        }
        
        // swap the pivot element (s[h]) to its correct position
        swap(s, p, h);

        return p;
    }

    // sorts the array using quicksort with Lomuto's partition scheme and smaller-side optimization
    // further, we also utilize a stack to store the bounds to be sorted as to avoid recursion altogether
    public static void quicksort(String[] s) {
        Stack<int[]> stack = new Stack<>();
        
        // push initial bounds into stack
        stack.push(new int[]{0, s.length - 1});

        while (!stack.isEmpty()) {
            
            // on the first round, the array pushed in Line 60 will be popped, thereby assigining l and h 
            // their overall correct values

            int[] r = stack.pop();
            int l = r[0];
            int h = r[1];

            if (l<h) {
                int p = partition(s, l, h);

                // pushes two new bounds into stack which will get sorted on the next iteration of the loop
                // Push the smaller subarray first
                if (p - l < h - p) {
                    stack.push(new int[]{p + 1, h});
                    stack.push(new int[]{l, p - 1});
                } else {
                    stack.push(new int[]{l, p - 1});
                    stack.push(new int[]{p + 1, h});
                }
            }
        }
    }

    // swap method for array s, swabs s[a], s[b]
    public static void swap(String[] s, int a, int b) {
        String temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }

    public static void print(String[] data) {
        for (String s : data) {
            System.out.println(s);
        }
    }
}

