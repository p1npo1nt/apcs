import java.util.*;

public class Main {
    public static void main(String[] args) {
        myList list = new myList();
        Scanner sc = new Scanner(System.in); 

        while(true) {
            System.out.print("Enter cmd: ");
            // reads input and trims whitespaces, 'rest' variable contains the input excluding the command
            String input = sc.nextLine().trim();
            String rest = input.substring(input.indexOf(" ")+1, input.length()).trim();
            //

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
                    return;
                default:
                    throw new IllegalArgumentException("No valid input command provided");
            }
        }
    }
}
