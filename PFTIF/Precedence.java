public class Precedence {
    private String[] operators;
    private int[] I_precedence;
    private int[] ST_precedence;

    public Precedence(String[] operators, int[] I_precedence, int[] ST_precedence) {
        this.operators = operators;
        this.I_precedence = I_precedence;
        this.ST_precedence = ST_precedence;

    }
    
    public int getInputPrecedence(String operator) {
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals(operator)) {
                return I_precedence[i];
            }
        }
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }

    public int getStackPrecedence(String operator) {
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals(operator)) {
                return ST_precedence[i];
            }
        }
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }
}
