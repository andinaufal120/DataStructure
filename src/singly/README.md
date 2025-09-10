# Singly Linked List Implementation

This package contains a complete implementation of a **Singly Linked List** data structure in Java. A singly linked list is a linear data structure where each element (node) contains data and a reference (link) to the next node in the sequence.

## Structure Overview

### Node Structure
Each node in the singly linked list contains:
- **value**: The data stored in the node
- **next**: A reference to the next node in the list (null for the last node)

```
┌─────────┬──────┐
│  value  │ next │
└─────────┴──────┘
```

### LinkedList Structure
The LinkedList class maintains:
- **first**: Reference to the first node in the list
- **size**: The number of elements currently in the list

## Visual Representation

### Empty List
```
LinkedList: first = null, size = 0
```

### Single Element List
```
LinkedList: first → ┌───┬──────┐
                    │ 1 │ null │
                    └───┴──────┘
size = 1
```

### Multiple Elements List
```
LinkedList: first → ┌───┬──┐   ┌───┬──┐   ┌───┬──────┐
                    │ 1 │ ●│──▶│ 2 │ ●│──▶│ 3 │ null │
                    └───┴──┘   └───┴──┘   └───┴──────┘
size = 3
```

## Operations and Time Complexity

### Core Operations

| Operation | Method | Time Complexity | Description |
|-----------|--------|-----------------|-------------|
| **Add to end** | `add(value)` | O(n) | Adds element to the end of the list |
| **Insert at index** | `insert(value, index)` | O(n) | Inserts element at specified position |
| **Get first** | `getFirst()` | O(1) | Returns the first element |
| **Get last** | `getLast()` | O(n) | Returns the last element |
| **Get by index** | `get(index)` | O(n) | Returns element at specified index |
| **Remove first** | `removeFirst()` | O(1) | Removes the first element |
| **Remove last** | `removeLast()` | O(n) | Removes the last element |
| **Remove by index** | `remove(index)` | O(n) | Removes element at specified index |
| **Swap elements** | `swap(index1, index2)` | O(n) | Swaps two elements at given indices |
| **Check empty** | `isEmpty()` | O(1) | Returns true if list is empty |
| **Get size** | `getSize()` | O(1) | Returns the number of elements |

### Operation Examples

#### Adding Elements
```
Initial: empty list
add(1): [1]
add(2): [1] → [2]
add(3): [1] → [2] → [3]
```

#### Inserting Elements
```
List: [1] → [2] → [3]
insert(99, 1): [1] → [99] → [2] → [3]
```

#### Removing Elements
```
List: [1] → [2] → [3]
removeFirst(): [2] → [3]
removeLast(): [2]
```

## Implementation Details

### Node Class
The `Node<E>` class is a private static inner class with:
- **Immutable value**: Once set, the value cannot be changed
- **Mutable next reference**: Can be updated to link to different nodes
- **Generic type support**: Works with any data type

### LinkedList Class
The `LinkedList<E>` class provides:
- **Generic type support**: Can store any type of objects
- **Exception handling**: Throws appropriate exceptions for invalid operations
- **Memory efficient**: Only stores references to first node and size

## Usage Example

```java
import singly.LinkedList;

// Create a new list
LinkedList<Integer> list = new LinkedList<>();

// Add elements
list.add(1);        // [1]
list.add(2);        // [1] → [2]
list.add(3);        // [1] → [2] → [3]

// Insert at specific position
list.insert(0, 0);  // [0] → [1] → [2] → [3]

// Access elements
int first = list.getFirst();  // 0
int last = list.getLast();    // 3
int second = list.get(1);     // 1

// Modify list
list.swap(0, 3);     // [3] → [1] → [2] → [0]
list.removeFirst();  // [1] → [2] → [0]
list.removeLast();   // [1] → [2]

// Check status
boolean empty = list.isEmpty();  // false
int size = list.getSize();       // 2
```

## Advantages and Disadvantages

### Advantages
- **Dynamic size**: Can grow and shrink during runtime
- **Memory efficient**: Only allocates memory as needed
- **Simple implementation**: Straightforward structure and operations
- **Cache friendly**: Sequential access pattern

### Disadvantages
- **Sequential access only**: Cannot directly access elements by index
- **No backward traversal**: Can only move forward through the list
- **Higher memory overhead**: Each node requires extra memory for the next pointer
- **Poor cache locality**: Nodes may be scattered in memory

## Common Use Cases
- **Stack implementation**: Using only first element operations
- **Queue implementation**: Adding to end and removing from beginning
- **Undo functionality**: Maintaining a history of operations
- **Music playlist**: Sequential playback with next song functionality