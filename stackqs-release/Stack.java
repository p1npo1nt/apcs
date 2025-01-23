public class Stack <E> {
    private Node<E> head;

    // initialize stack with empty node
    public Stack() {
        this.head = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    // initializes new node c with a next to the top (head), then sets the head node to c
    void push(E d) {
        Node<E> c = new Node<E>(d, head);
        head = (c);
    }

    E pop() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        else {
            E data = head.getData();
            head = head.getNext();
            return data;
        }
    }
}