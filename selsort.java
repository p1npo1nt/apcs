import java.util.*;

public class sesort { 
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

            if(line.isEmpty()) {
                break;
            }
            
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

    public static String[] selSort(String[] a) {
        int len = a.length;
        String temp = "";

        // Loop through each element in the array
        for (int i = 0; i < len - 1; i++) {
            int min = i;
    
            for (int j = i + 1; j < len; j++) {
               
                if (a[j] != null && a[min] != null && a[j].compareTo(a[min]) < 0) {
                    min = j; // Update min if a smaller element is found
                }
            }

            // Swap min element with first unordered element
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
            
        }
        
        return a;
    }
    
    public static void print(String[] a) {
        String[] sorted = selSort(a);

        for(int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
    }
}
