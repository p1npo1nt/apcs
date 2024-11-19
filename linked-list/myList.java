public class myList {
    // linked list

   private Node head; // entry node into the linked list

   public myList() {
       // constructor
       this.head = null;
   }

   public void insert(String d) {
        // adds a new node to the linked list by adding a node at the beginning and providing it with a reference to the head

       Node t = new Node(d, this.head);
       this.head = t;
   }

   public void print() {
       // prints out contents of the linked list via the following operatoin:
       // keep traversing the nodes until you reach the head node which has a value of null
       // t refers to the head node
       
       Node t = this.head;
      
       while (t != null) { 
           System.out.println(t.getData());
           t = t.getNext();
       }
   }

   public boolean contains(String d) {
       Node t = this.head;

       while (t != null) { 
           if (t.getData().equals(d)) return true;
           t = t.getNext();
       }

       return false;
   }
}