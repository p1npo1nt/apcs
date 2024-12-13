public class Node {
    private String d;
    private Node next;

    // constructor: data, next reference
    public Node(String d, Node next) { 
        this.d = d;
        this.next = next;
    }

    public String getData() {
        return this.d;
    }

    public Node getNext() { 
        return this.next;
    }

    public void setNext(Node next) {
        // updates reference to next node
        this.next = next;
    }
}
