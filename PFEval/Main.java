
import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get expression from user
        String exp = scanner.nextLine();
        
        scanner.close();

        // tokenize the input here by whitespace
        String[] tokens = exp.split("\\s+");

        double evaluation = PFEval(tokens);

        System.out.println("Evaluation: " + evaluation);

    }

    public static double PFEval(String[] exp) {
        Stack numbers = new Stack();
        
        
        for (String t : exp) {
            if(isNumeric(t)) {
                numbers.push(Double.parseDouble(t));
            }
            else {
                // a is the RHS operand, b is the LHS operand
                double a = numbers.pop();
                double b = numbers.pop();

                String operator = t;
                switch(operator) {
                    case "+":
                        numbers.push(b+a);
                        break;
                    case "-":
                        numbers.push(b-a);
                        break;
                    case "*":
                        numbers.push(b*a);
                        break;
                    case "/":
                        if (a != 0) {
                            numbers.push(b/a);  
                        } else {
                            System.out.println("Error: Division by zero.");
                            // GIGO
                            return -1;
                        }
                        break;
                    default:
                        System.out.println("Unknown operator encountered");
                        return -1;
                }
            } 
        }

        // Should be one element in the stack, pop it, that's the result
        return numbers.pop();
    }

    // checks if token is a number
    public static boolean isNumeric(String s) { 
        try {  
          Double.parseDouble(s);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
      }
}
