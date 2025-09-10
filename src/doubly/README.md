# Doubly Linked List Implementation

This package contains a basic implementation framework for a **Doubly Linked List** data structure in Java. A doubly linked list is a linear data structure where each element (node) contains data and references (links) to both the next and previous nodes in the sequence.

## Structure Overview

### Node Structure
Each node in the doubly linked list contains:
- **value**: The data stored in the node
- **next**: A reference to the next node in the list (null for the last node)
- **prev**: A reference to the previous node in the list (null for the first node)

```
┌──────┬─────────┬──────┐
│ prev │  value  │ next │
└──────┴─────────┴──────┘
```

### LinkedList Structure
The LinkedList class maintains:
- **first**: Reference to the first node in the list
- **last**: Reference to the last node in the list
- **size**: The number of elements currently in the list

## Visual Representation

### Empty List
```
LinkedList: first = null, last = null, size = 0
```

### Single Element List
```
LinkedList: first ──┐   ┌── last
                    │   │
                    ▼   ▼
                ┌──────┬───┬──────┐
                │ null │ 1 │ null │
                └──────┴───┴──────┘
size = 1
```

### Multiple Elements List
```
LinkedList: first ──┐                               ┌── last
                    │                               │
                    ▼                               ▼
                ┌──────┬───┬──┐   ┌──┬───┬──┐   ┌──┬───┬──────┐
                │ null │ 1 │ ●│──▶│ ●│ 2 │ ●│──▶│ ●│ 3 │ null │
                └──────┴───┴──┘   └──┴───┴──┘   └──┴───┴──────┘
                            ◀──────────┘   ◀──────────┘
size = 3
```

### Bidirectional Linking Visualization
```
        ┌─────────── Forward Direction ──────────▶
    ┌──────┬───┬──┐   ┌──┬───┬──┐   ┌──┬───┬──────┐
    │ null │ 1 │ ●│──▶│ ●│ 2 │ ●│──▶│ ●│ 3 │ null │
    └──────┴───┴──┘   └──┴───┴──┘   └──┴───┴──────┘
          ◀──────────── Backward Direction ───────────┘
```

## Implementation Status

### Currently Implemented
| Method | Description | Time Complexity |
|--------|-------------|-----------------|
| `LinkedList()` | Constructor - creates empty list | O(1) |
| `isEmpty()` | Checks if the list is empty | O(1) |
| `size()` | Returns the number of elements | O(1) |

### Node Class Features
The `Node<E>` inner class includes:
- **Immutable value**: Data storage
- **Bidirectional references**: Both next and prev pointers
- **Complete getter/setter methods**: For all node properties

## Potential Operations (Framework Ready)

The current Node structure supports implementing these operations:

### Basic Operations
| Operation | Expected Time Complexity | Description |
|-----------|-------------------------|-------------|
| **Add to front** | O(1) | Insert at the beginning |
| **Add to back** | O(1) | Insert at the end |
| **Add at index** | O(n) | Insert at specific position |
| **Remove first** | O(1) | Remove from beginning |
| **Remove last** | O(1) | Remove from end |
| **Remove at index** | O(n) | Remove from specific position |
| **Get first** | O(1) | Access first element |
| **Get last** | O(1) | Access last element |
| **Get at index** | O(n) | Access element by index |
| **Find element** | O(n) | Search for specific value |

### Advanced Operations
| Operation | Expected Time Complexity | Description |
|-----------|-------------------------|-------------|
| **Reverse** | O(n) | Reverse the entire list |
| **Bidirectional traversal** | O(n) | Traverse forward or backward |
| **Insert before/after** | O(1)* | Insert relative to given node |
| **Merge lists** | O(1) | Combine two doubly linked lists |

*O(1) if you have reference to the node, O(n) if searching by value

## Node Implementation Details

### Constructor
```java
public Node(E value, Node<E> next, Node<E> prev)
```
Creates a node with all three components initialized.

### Accessor Methods
- `getValue()`: Returns the stored data
- `getNext()`: Returns reference to next node
- `getPrev()`: Returns reference to previous node

### Mutator Methods
- `setNext(Node<E> next)`: Updates next reference
- `setPrev(Node<E> prev)`: Updates previous reference

## Advantages of Doubly Linked Lists

### Over Singly Linked Lists
- **Bidirectional traversal**: Can move both forward and backward
- **Efficient deletion**: O(1) deletion when you have node reference
- **Better for certain algorithms**: Like LRU cache implementation
- **Easier reverse operations**: No need to track previous nodes

### General Advantages
- **Dynamic size**: Grows and shrinks as needed
- **Constant time insertion/deletion**: At known positions
- **No memory waste**: Allocates exactly what's needed

## Disadvantages

- **Higher memory overhead**: Extra pointer per node (prev)
- **More complex implementation**: Additional pointer management
- **Slower cache performance**: More memory accesses per node
- **Higher complexity**: More prone to implementation errors

## Implementation Example Framework

Here's how operations could be implemented:

### Adding to Front (Pseudo-code)
```java
public void addFirst(E value) {
    Node<E> newNode = new Node<>(value, first, null);
    if (isEmpty()) {
        first = last = newNode;
    } else {
        first.setPrev(newNode);
        first = newNode;
    }
    size++;
}
```

### Adding to Back (Pseudo-code)
```java
public void addLast(E value) {
    Node<E> newNode = new Node<>(value, null, last);
    if (isEmpty()) {
        first = last = newNode;
    } else {
        last.setNext(newNode);
        last = newNode;
    }
    size++;
}
```

## Common Use Cases

- **Browser history**: Back and forward navigation
- **Media players**: Previous and next track functionality
- **Undo/Redo systems**: Bidirectional operation history
- **LRU Cache**: Efficient insertion and deletion
- **Text editors**: Cursor movement and text manipulation
- **Game development**: Player movement in both directions

## Future Implementation Recommendations

To complete this doubly linked list implementation, consider adding:

1. **Core CRUD operations**: add, remove, get methods
2. **Iterator support**: For enhanced for-loop compatibility
3. **Bulk operations**: addAll, removeAll, clear methods
4. **Utility methods**: contains, indexOf, toString
5. **Error handling**: Proper exception throwing for edge cases

The current Node structure provides a solid foundation for implementing all these features efficiently.