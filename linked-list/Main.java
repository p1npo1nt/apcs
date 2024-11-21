import java.util.*;

public class Main {
    public static void main(String[] args) {
        myList list = new myList();

        //* INPUT BLOCK
        Scanner sc = new Scanner(System.in); 

        while(true) {
            System.out.print("Enter cmd: ");
            // reads input and trims whitespaces, 'rest' variable contains the input excluding the command
            String input = sc.nextLine().trim();
            String rest = input.substring(1, input.length()).trim();

            if (input.isEmpty()) {
                throw new IllegalArgumentException("No input command provided");
            }

            switch(input.charAt(0)) {
                case 'p':
                    list.print();
                    break;
                case 'i':
                    list.insert(rest);
                    System.out.println("Inserted: " + rest);
                    break;
                case 'd':
                    if (list.delete(rest)) {
                        list.delete(rest); 
                        System.out.println("Deleted: " + rest);
                    } else {
                        System.out.println("Could not delete: " + rest);
                    }
                    break;
                case 'c':
                    System.out.println(list.contains(rest));
                    break;
                case 'q':
                    sc.close();
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
