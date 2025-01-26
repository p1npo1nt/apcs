import java.util.*;

public class Main {
    public static void main(String[] args) {

        // receive user input
        System.out.print("INFIX: ");
        Scanner scanner = new Scanner(System.in);
        String[] tokens = tokenize(scanner.nextLine());
        scanner.close();

        // conditional makes sure that the inputed INFIX is valid
        // transform and evaluate INFIX and POSTFIX respectively
        if(checkAllStates(tokens)) {
            System.out.print("POSTFIX: ");
            printArray(toPostFix(tokens));

            System.out.print("EVAL: ");
            System.out.print(postFixEval(toPostFix(tokens)) + "\n");
        } else {
            System.out.print("Invalid INFIX expression: ");
            printArray(tokens);
        }
    }

    public static String[] toPostFix(String[] infix) {
        // converts INFIX to POSTFIX

        final String[] operators = {"+", "-", "*", "/", "^", "(", ")"};
        
        // how operators behave when encountered in the input expression
        final int[] I_precedence = {1, 1, 3, 3, 6, 10, 0};
        
        // how operators should be handled when on the stack
        final int[] ST_precedence = {2, 2, 4, 4, 5, 0, 10};

        // initialize a precedence table
        Precedence precedence = new Precedence(operators, I_precedence, ST_precedence);

        myStack<String> opStack = new myStack<String>();
        String[] output = new String[infix.length];

        int i = 0;
        for (String t : infix) {
            if (t == null || t.trim().isEmpty()) {
                continue;  // Skip empty tokens
            }
            if (isNumeric(t)) {
                // if t is a number, add it to the output array
                output[i++] = t;
            } else if (t.equals("(")) {
                // if t is '(', push it onto the operator stack
                opStack.push(t);
            } else if (t.equals(")")) {
                while (!opStack.isEmpty() && !opStack.peek().equals("(")) {
                    output[i++] = opStack.pop();
                }
                opStack.pop(); // Discard the '('
            } else {
                // if t is an operator, handle precedence
                // keep popping until the stack precedence of the operator is
                // less than the input precedence of the operator in question
                while (!opStack.isEmpty() && precedence.getStackPrecedence(opStack.peek()) >= precedence.getInputPrecedence(t)) {
                    output[i++] = opStack.pop();
                }

                // finally, push the operator
                opStack.push(t);
            }
        }

        // flush any remaining operators
        while (!opStack.isEmpty()) {
            output[i++] = opStack.pop();
        }

        return output;
    }
    
    
    // Postfix evaluation
    public static double postFixEval(String[] exp) {
        // evaluates a POSTFIX expression

        myStack<Double> numbers = new myStack<>();
        
        for (String t : exp) {
            if (t == null || t.trim().isEmpty()) {
                continue;  // Skip empty tokens
            }
            if (isNumeric(t)) {
                numbers.push(Double.parseDouble(t));
            }
            else {
                // a is the RHS operand, b is the LHS operand
                
                if (numbers.getSize() >= 2) {
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
                                System.out.println("ERROR: Division by zero");
                                // GIGO
                                return -1;
                            }
                            break;
                        case "^":
                            numbers.push(Math.pow(b, a));
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
        if (numbers.getSize() > 1) {
            // handles the case where a binary operator takes >2 operands 
            throw new IllegalArgumentException("Invalid postfix epression");
        }
        return numbers.pop();
    }

    public static boolean checkAllStates(String[] tokens) {
        // checks for validity of INFIX expression

        final int EXPECT_OPERAND = 0;
        final int EXPECT_OPERATOR = 1;

        int state = EXPECT_OPERAND;
        int parenthesesNeedingClosing = 0;

        for (String t : tokens) {
            if(state == EXPECT_OPERAND) {
                if (isNumeric((t))) {
                    // valid operand or opening parentheses
                    state = EXPECT_OPERATOR;
                } else if (t.equals("(")) {
                    state = EXPECT_OPERAND;
                    parenthesesNeedingClosing++;
                } else {
                    System.out.println("ERROR: Expected operand, found '" + t + "'");
                    return false;
                }
            } else if (state == EXPECT_OPERATOR) {
                if (isOperator(t)) {
                    state = EXPECT_OPERAND;
                } else if (t.equals(")")) {
                    state = EXPECT_OPERATOR;
                    parenthesesNeedingClosing--;
                } else {
                    System.out.println("ERROR: Expected operator, found '" + t + "'");
                    return false;
                }
            }
            if (parenthesesNeedingClosing != 0) {
                System.out.println("ERROR: All parentheses are not closed");
                return false;
            }
        }

        // final state must be that we expect an operator
        if (state != EXPECT_OPERATOR) {
            System.out.println("Expression ended prematurely");
            return false;
        }

        return true;
    }

    public static boolean isNumeric(String s) { 
        if (s == null || s.trim().isEmpty()) {
            return false;  // avoid empty or null strings
        }
        try {  
          Double.parseDouble(s);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
    }

    public static boolean isOperator(String s) {
        return "+-*/^".contains(s);
    }

    public static String[] tokenize(String e) {
        return e.split("\\s+");
    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            if (element != null) { System.out.print(element + " "); }
        }
        System.out.println();  // To move to the next line after printing all elements
    }
}
