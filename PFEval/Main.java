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
                
                if (numbers.size() >= 2) {
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
                            throw new IllegalArgumentException("Unknown operator encountered");
                    }   
                }
                else {
                        throw new IllegalArgumentException("Invalid postfix expression");
                } 
            }
        } 
        // Should be one element in the stack, pop it, that's the result
        if (numbers.size() > 1) {
            // handles the case where a binary operator takes >2 operands 
            throw new IllegalArgumentException("Invalid postfix epression");
        }
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
