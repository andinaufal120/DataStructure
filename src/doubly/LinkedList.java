package doubly;

public class LinkedList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    /// Constructs an empty list.
    public LinkedList() {
    }

    /// Checks if the list is empty.
    ///
    /// @return true if the list contains no elements, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    /// Returns the number of elements in the list.
    ///
    /// @return the size of the list
    public int size() {
        return size;
    }


    /// Represents a node in a doubly linked list.
    ///
    /// @param <E>
    public static class Node<E> {
        private final E value;
        private Node<E> next;
        private Node<E> prev;

        public Node(E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public E getValue() {
            return value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
}
