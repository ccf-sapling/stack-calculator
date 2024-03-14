public class SinglyLinkedList<E>
{
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node <E> n) {
            this.element = e;
            this.next = n;
        }

        // Getters/Setters
        public E getElement() {
            return this.element;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setNext(Node<E> n) {
            this.next = n;
        }
    }
    // End of nested class

    // Instance variables of SinglyLinkedList
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    // Constructor constructs an initially empty SLL
    public SinglyLinkedList() {
    }

    // Access methods
    public int size() {
        return this.size;
    }

    // Returns true if size is 0, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // If size is 0, return null, otherwise return element in head
    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    // If size is 0, return null, otherwise return element in tail
    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // Update methods
    // Point head to the new node, and if size is 0, tail also = head. Inc. size.
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) tail = head;
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null); // Node will eventually be the tail.
        if (isEmpty()) head = newest;
        else tail.setNext(newest);
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) tail = null;
        return answer;
    }

    /**
     * Initialize a StringBuilder object, sb, then store the head node in the currentNode var.
     * Use a loop to traverse the linked list and print out each element in each node.
     * With the for loop, can use the size attribute as the upper bound, then append each
     * element to the sb object with its append() method. Then, set the currentNode to the
     * next node in the SLL with the getNext() method of the Node class.
     * 
     * Can use a while loop as well. While there's a currentNode (more nodes exist), continue
     * the loop, while assigning currentNode the value of the next node in the list after
     * each iteration.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> currentNode = head;
        for (int i = 0; i < this.size; i++) {
            sb.append(currentNode.getElement() + "\n");
            currentNode = currentNode.getNext();
        }
        /*while (currentNode != null) {
        sb.append(currentNode.getElement() + "\n");
        currentNode = currentNode.getNext();
        }*/
        return sb.toString();
    }
}
