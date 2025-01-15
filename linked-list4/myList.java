import java.util.Iterator;

public class myList<E extends Comparable<E>> implements Iterable<E>{
    private Node<E> head;

    public myList(){
        this.head = null;
    }

    public Iterator<E> iterator(){
        return new ListIter(this.head);
    }

    private class ListIter implements Iterator<E>
    {
        private Node<E> c;

        ListIter(Node<E> c){
            this.c = c;
        }

        public boolean hasNext(){
            return this.c != null;
        }

        public E next(){
            E t = this.c.getData();
            this.c = this.c.getNext();
            return t;
        }
    }

    public void insert(E d){

        Node<E> t = this.head;

        if (t == null || t.getData().compareTo(d) > 0){
            this.head = new Node<E>(d, head);
            return;
        }
    
        while (t.getNext() != null && t.getNext().getData().compareTo(d) <= 0){
            t = t.getNext();
        }
    
        Node<E> c = new Node<E>(d, t.getNext());
        t.setNext(c);
        
        return;
    }     

    public boolean contains(E d){
        Node<E> t = this.head;
        while(t != null){
            if(t.getData().equals(d)){
                return true;
            }
            t = t.getNext();
        }
        return false;
    }

    public boolean remove(E d) {
        if (this.head == null) return false; // List is empty, nothing to remove
    
       
        if (this.head.getData().equals(d)) {
            this.head = this.head.getNext();
            return true; 
        }
    
        Node<E> t = this.head;
        while (t.getNext() != null) {
            if (t.getNext().getData().equals(d)) {
                t.setNext(t.getNext().getNext());
                return true; // Successfully removed the node
            }
            t = t.getNext();
        }
    
        return false; 
    }
    
}