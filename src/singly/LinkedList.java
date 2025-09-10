package singly;

import java.util.NoSuchElementException;

/// An implementation of a one-way, singly linked list, where the list is a one-ended list.
///
/// Access into the list will traverse the list from the beginning to the end of the list.
///
/// Access to the first or last element when the list is empty will throw {@link NoSuchElementException}.
///
/// @param <E>
/// @author Andi Naufal Nurfadhil
public class LinkedList<E> {
    private int size;
    private Node<E> first;

    // Construct an empty list.
    public LinkedList() {
    }

    /// Adds a new element to the end of the list.
    ///
    /// @param value the value to be added to the list
    public void add(E value) {
        Node<E> newNode = new Node<>(value, null);
        if (first == null) {
            first = newNode;
        } else {
            // Start traversing from the first node.
            Node<E> last = first;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(newNode);
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
            first = new Node<>(value, first);
            size++;
            return;
        }
        Node<E> newNode = new Node<>(value, null);
        Node<E> current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    /// Returns the value of the first element.
    ///
    /// @return the value of the first element in the list
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }
        return first.getValue();
    }

    /// Traverses to the last element and returns the value.
    ///
    /// @return the value of the last element in the list
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }
        Node<E> current = first;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getValue();
    }

    /// Returns the value at the specified index.
    ///
    /// @param index index to be searched
    /// @return the requested value
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    /// Remove the first element of the list.
    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }
        first = first.getNext();
        size--;
    }

    /// Remove the last element of the list.
    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }
        Node<E> current = first;
        for (int i = 0; i < size - 2; i++) {
            current = current.getNext();
        }
        current.setNext(null);
        size--;
    }

    /// Removes an element at the specified index.
    /// 
    /// @param index the index to be removed from the list
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Node<E> current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        size--;
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

        // Normalize order by ensuring index1 is smaller than index2
        if (index1 > index2) {
            int temp = index1;
            index1 = index2;
            index2 = temp;
        }

        // Locate the nodes to swap and their previous node
        Node<E> prev1 = null;
        Node<E> curr1 = first;
        for (int i = 0; i < index1; i++) {
            prev1 = curr1;
            curr1 = curr1.getNext();
        }

        Node<E> prev2 = null;
        Node<E> curr2 = first;
        for (int i = 0; i < index2; i++) {
            prev2 = curr2;
            curr2 = curr2.getNext();
        }

        if (prev1 != null) {
            prev1.setNext(curr2);
        } else {
            first = curr2;
        }

        if (prev2 != null) {
            prev2.setNext(curr1);
        } else {
            first = curr1;
        }

        Node<E> temp = curr1.getNext();
        curr1.setNext(curr2.getNext());
        curr2.setNext(temp);
    }

    /// Checks whether the linked list is empty.
    ///
    /// @return true if the list contains no elements, false otherwise.
    public boolean isEmpty() {
        return first == null;
    }

    /// Returns the size/length of the list.
    ///
    /// @return the size/length of the list
    public int getSize() {
        return size;
    }


    /// Represents a node in a one-way linked list.
    ///
    /// @param <E>
    private static class Node<E> {
        private final E value;
        private Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
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
    }
}
