public class Node <E> {
    private E d;
    private Node<E> next;

    // constructor: data, next reference
    public Node(E d, Node<E> next) { 
        this.d = d;
        this.next = next;
    }

    public E getData() {
        return this.d;
    }

    public Node<E> getNext() { 
        return this.next;
    }

    public void setNext(Node<E> next) {
        // updates reference to next node
        this.next = next;
    }
}
