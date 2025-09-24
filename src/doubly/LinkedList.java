package doubly;

import java.util.NoSuchElementException;

public class LinkedList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    /// Constructs an empty list.
    public LinkedList() {
    }

    /// Adds a new element to the end of the list.
    ///
    /// @param value the value to be added to the list
    public void add(E value) {
        Node<E> newNode = new Node<>(value, null, null);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            Node<E> tail = last;
            tail.setNext(newNode);
            newNode.setPrev(tail);
            last = newNode;
        }
        size++;
    }

    /// Inserts a new element at the specified index.
    ///
    /// @param value the value to be added to the list
    /// @param index the index to put the new element
    public void insert(E value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            if (size == 0) {
                add(value);
                return;
            }
            first = new Node<>(value, first, null);
            first.getNext().setPrev(first);
            size++;
            return;
        } else if (index == size) {
            add(value);
            return;
        }
        Node<E> newNode = new Node<>(value, null, null);
        Node<E> current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        Node<E> successor = current.getNext();
        newNode.setNext(successor);
        newNode.setPrev(current);
        current.setNext(newNode);
        if (successor != null) {
            successor.setPrev(newNode);
        } else {
            last = newNode;
        }
        size++;
    }

    /// Returns the first node.
    ///
    /// @return the first node in the list
    public Node<E> getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }
        return first;
    }

    /// Returns the last node.
    ///
    /// @return the last node in the list
    public Node<E> getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }
        return last;
    }

    /// Returns the node at the specified index.
    ///
    /// @param index index to be searched
    /// @return the requested node
    public Node<E> get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return first;
        } else if (index == size - 1) {
            return last;
        }
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    /// Remove the first element of the list.
    public Node<E> removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }
        Node<E> temp = first;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.getNext();
            first.setPrev(null);
        }
        size--;
        return temp;
    }

    /// Remove the last element of the list.
    public Node<E> removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }
        Node<E> temp = last;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = last.getPrev();
            last.setNext(null);
        }
        size--;
        return temp;
    }

    /// Removes an element at the specified index.
    ///
    /// @param index the index to be removed from the list
    public Node<E> remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return current;
    }

    /// Swaps the positions of two elements in the linked list located at the specified indices.
    ///
    /// @param index1 the index of the first element to swap
    /// @param index2 the index of the second element to swap
    /// @throws IndexOutOfBoundsException if either index1 or index2 is negative or exceeds the size of the list
    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index1 == index2) {
            return;
        }

        // Ensure index1 is smaller than index2
        if (index1 > index2) {
            int temp = index1;
            index1 = index2;
            index2 = temp;
        }

        Node<E> node1 = get(index1);
        Node<E> node2 = get(index2);

        // Handle the case where nodes are adjacent
        boolean adjacent = (node1.getNext() == node2);

        Node<E> temp1Prev = node1.getPrev();
        Node<E> temp1Next = node1.getNext();
        Node<E> temp2Prev = node2.getPrev();
        Node<E> temp2Next = node2.getNext();

        // Update first/last references if necessary
        if (node1 == first) {
            first = node2;
        } else if (node2 == first) {
            first = node1;
        }
        if (node1 == last) {
            last = node2;
        } else if (node2 == last) {
            last = node1;
        }

        // Set previous links
        if (temp1Prev != null) {
            temp1Prev.setNext(node2);
        }
        node2.setPrev(temp1Prev);

        if (temp2Prev != null && !adjacent) {
            temp2Prev.setNext(node1);
        }
        node1.setPrev(adjacent ? node2 : temp2Prev);

        // Set next links
        if (temp2Next != null) {
            temp2Next.setPrev(node1);
        }
        node1.setNext(temp2Next);

        if (temp1Next != null && !adjacent) {
            temp1Next.setPrev(node2);
        }
        node2.setNext(adjacent ? node1 : temp1Next);
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
