public class LinkedStack<E> implements Stack<E>{
    SinglyLinkedList<E> sll = new SinglyLinkedList<>(); // initialize SLL

    // Methods from Stack interface
    public int size() {
        return this.sll.size();
    }
    public boolean isEmpty() {
        return this.sll.isEmpty();
    }
    public void push(E e) {
        this.sll.addFirst(e);
    }
    // See element at top of stack (first element)
    public E top() {
        return this.sll.first();
    }
    public E pop() {
        return this.sll.removeFirst();
    }

    public void displayStack() {
        System.out.println(sll.toString());
    }
}
