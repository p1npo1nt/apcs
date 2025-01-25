package old;
import java.util.*;

public class insort {  
    public static void main(String[] args) {
        // Read-in 
        String[] a = getData();

        print(a);
    }

    public static String[] getData() {

        int i = 0;
        int maxsize = 1000;

        Scanner pathInput = new Scanner(System.in);
        String[] d = new String[maxsize];

        // Proper size of the array based on the file length
        int newsize = 0;

        while(pathInput.hasNextLine() && i < maxsize) {
            String line = pathInput.nextLine();
            
            d[i] = line;
            i+=1;
            newsize+=1;
        }

        pathInput.close();

        // New array to copy old data into this time with correct length
        String[] d2 = new String[newsize];
        
        // Copying old data into new data with correct length
        int j = 0; 
        while(j < d2.length) {
            d2[j] = d[j];
            j+=1;
        }

        return d2;
    }

    public static String[] insertionSort(String[] a) {
        int i = 1;
        int j = 0;

        while(i < a.length) {
            String temp = a[i];
            j = i;

            // Keeps shifting to make room for temp
            while(j>0 && a[j-1].compareTo(temp)>0) {
                a[j] = a[j-1];
                j-=1; 
            }
            a[j] = temp;
            i+=1;
        }
        
        return a;
    }

    public static void print(String[] a) {
        String[] sorted = insertionSort(a);

        for(int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
    }
}
