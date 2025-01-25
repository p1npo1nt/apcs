import java.util.*;

public class Main {
    static myList<String> list = new myList<String>(); // 
    static Scanner sc = new Scanner(System.in); 

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter cmd: ");
            String input = sc.nextLine().trim();

            // Split command and argument
            String[] inputs = input.split("\\s+", 2);
            String command = inputs[0];
            String rest = inputs.length > 1 ? inputs[1].trim() : "";

            switch (command.charAt(0)) {
                case 'p': 
                    Iterator<String> listI = list.iterator();
                    while(listI.hasNext()) {
                        System.out.println(listI.next());
                    }
                    break;

                case 'i': 
                    if (!rest.isEmpty()) {
                        list.insert(rest);
                        System.out.println("Inserted: " + rest);
                    } else {
                        System.out.println("Must specify an element");
                    }
                    break;

                case 'd': 
                    if (!rest.isEmpty()) {
                        if (list.remove(rest)) {
                            System.out.println("Deleted: " + rest);
                        } else {
                            System.out.println("Could not delete: " + rest);
                        }
                    } else {
                        System.out.println("No input provided");
                    }
                    break;

                case 'c': 
                    if (!rest.isEmpty()) {
                        if (list.contains(rest)) {
                            System.out.println(list.contains(rest));
                        } else {
                            System.out.println(false);
                        }
                    } else {
                        System.out.println("Must specify an element");
                    }
                    break;

                case 'q': // Quit the program
                    sc.close();
                    return;

                default: // Invalid command
                    throw new IllegalArgumentException("No valid input command provided");
            }
        }
    }
}
