# Data Structure Implementations

A comprehensive collection of fundamental data structure implementations in Java, designed for educational purposes and practical understanding of computer science concepts.

## 📚 Available Data Structures

### [Singly Linked List](src/singly/README.md)
- **Package**: `singly.LinkedList<E>`
- **Status**: ✅ Fully Implemented
- **Features**: Complete CRUD operations, element swapping, size management
- **Time Complexity**: O(1) to O(n) depending on operation

### [Doubly Linked List](src/doubly/README.md)  
- **Package**: `doubly.LinkedList<E>`
- **Status**: ✅ Fully Implemented
- **Features**: Bidirectional traversal, optimized operations, complete CRUD support
- **Time Complexity**: O(1) to O(n) with bidirectional optimization

## 🚀 Quick Start

### Prerequisites
- Java 8 or higher
- Any Java IDE or command line tools

### Compilation
```bash
# Compile all source files
javac src/singly/LinkedList.java src/doubly/LinkedList.java src/Main.java

# Run the main class
java -cp src Main
```

### Basic Usage

#### Singly Linked List
```java
import singly.LinkedList;

LinkedList<Integer> list = new LinkedList<>();
list.add(1);
list.add(2);
list.insert(0, 0);  // Insert at beginning
System.out.println(list.getFirst().getValue()); // 0
```

#### Doubly Linked List
```java
import doubly.LinkedList;

LinkedList<String> list = new LinkedList<>();
list.add("Hello");
list.add("World");
System.out.println(list.getLast().getValue()); // World
```

## 🏗️ Project Structure

```
DataStructure/
├── src/
│   ├── singly/
│   │   ├── LinkedList.java    # Singly linked list implementation
│   │   └── README.md          # Detailed documentation
│   ├── doubly/
│   │   ├── LinkedList.java    # Doubly linked list implementation
│   │   └── README.md          # Detailed documentation
│   └── Main.java              # Example usage and testing
├── .gitignore
└── README.md                  # This file
```

## 📖 Documentation

Each data structure includes comprehensive documentation:

- **Implementation details** with time complexity analysis
- **Visual representations** of the data structure
- **Code examples** for all operations
- **Use cases** and practical applications
- **Advantages and disadvantages** comparison

## 🛠️ Implementation Features

### Common Features
- **Generic type support** (`<E>`) for type safety
- **Exception handling** with appropriate error messages
- **Memory efficient** implementations
- **Clean, documented code** following Java conventions

### Singly Linked List Specifics
- Linear traversal from head to tail
- Memory efficient with single link per node
- Optimized for stack-like operations

### Doubly Linked List Specifics
- Bidirectional traversal capability
- Optimized head and tail operations
- Better performance for certain algorithms (LRU cache, etc.)

## 👨‍💻 Author

**Andi Naufal Nurfadhil**
- Implementation and documentation
- Educational focus with practical examples

## 📄 License

This project is created for educational purposes. Feel free to use, modify, and learn from the implementations.

## 🤝 Contributing

This is an educational project. Suggestions for improvements, additional data structures, or enhanced documentation are welcome through issues and pull requests.

## 📈 Future Enhancements

Potential additions to this data structure collection:
- Stack implementation
- Queue implementation  
- Binary Tree structures
- Hash Table implementation
- Graph data structures