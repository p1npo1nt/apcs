public class Node {
    private String d;
    private Node next;

    // constructor
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
}
