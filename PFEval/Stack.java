
public class Stack {
    public static final int max = 1000;
    int top;

    double[] a = new double[max];

    public Stack() {
        top = -1;
    }

    // if our top element is at index max-1, we know that the stack is full.
    public boolean isFull() {
        return top >= max-1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    // increment top, push k doubleo a[top]
    public void push(double k) {
        if (isFull()) { throw new IllegalArgumentException("Stack overflow"); }
        else {
            top = top + 1;
            a[top] = k;
        }
    }

    // store the value at the top of the stack, decrement it, return the stored value
    public double pop() {
        if (isEmpty()) { throw new IllegalArgumentException("Stack underflow"); }
        else {
            double stored = a[top];
            top = top - 1;
            return stored; 
        }
    }

    public double peek() {
        if (isEmpty()) {System.out.println ("Stack is empty"); return 0; }
        else { return a[top]; }
    }

    public int size() { return top + 1; }
}
