public class myList {
    // linked list
    //* user interface commands
        // i cat (insert cat)
        // p (print list)
        // d cat (delete cat)
        // c cat (contains cat)
        // q (quit)
        // use Scanner.in to carry out this

   private Node head; // entry node into the linked list

   public myList() {
       //* constructor
       this.head = null;
   }

   public void insert(String d) {
        //* adds a new node to the linked list by adding a node at the beginning and providing it with a reference to the head

       Node t = new Node(d, this.head);
       this.head = t;
   }

   public void print() {
       //* prints out contents of the linked list via the following operation:
       //* keep traversing the nodes until you reach the head node which has a value of null
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


   public boolean delete(String d) {
        //* sets reference of node previous to node containing d to the node following d, 
        //* returns boolean value on ability to be deleated or not

        //! Edge case warning --- currently not able to delete last element of the linked list due to a null reference on its end [11/21 @ 5:35 PM]

        Node t = this.head;

        // head reference edge-case
        if (t.getData().equals(d)) {
            t.setNext(t.getNext().getNext());
        }

        // added RHS of and statement to make sure that 
        // NullPointerException is not thrown when reaching the end of the linked list
        while (t != null && t.getNext() != null) { 
           
            // find the desired node t with data d and set t's reference to the 
            // next next node such that it skips over the node with data d
            if (t.getNext().getData().equals(d)) {
                t.setNext(t.getNext().getNext());
                return true;
            }


            t = t.getNext();
        }
        
        return false;
   }
}
