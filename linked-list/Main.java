// To run, compile *.java (javac *.java) and then run Main (java Main)

public class Main {
    public static void main(String[] args) {
        myList list = new myList();
        list.insert("a");
        list.insert("b");
        list.insert("c");

        list.print();
    }
}
