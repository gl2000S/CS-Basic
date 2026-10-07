# CS Basics

Learning CS fundamentals by building them in Java.
Each topic lives in its own folder with runnable code (`Main.java`) 
and own notes (`NOTES.md`).

## Table of Contents

### 1. Object-Oriented Programming (`src/oop/`)

| # | Topic | Folder | What it covers | Status |
|---|-------|--------|----------------|--------|
| 1.1 | Encapsulation | [encapsulation](src/oop/encapsulation/) | Private fields, getters/setters, validation, `final` | [ ] |
| 1.2 | Inheritance | [inheritance](src/oop/inheritance/) | `extends`, `super(...)`, `protected`, constructor order | [ ] |
| 1.3 | Polymorphism | [polymorphism](src/oop/polymorphism/) | Parent-type variables, dynamic dispatch | [ ] |
| 1.3.1 | ↳ Overloading | [overloading](src/oop/polymorphism/overloading/) | Same name, different parameters, compile time | [ ] |
| 1.3.2 | ↳ Overriding | [overriding](src/oop/polymorphism/overriding/) | Same signature in child, `@Override`, runtime | [ ] |
| 1.4 | Abstraction | [abstraction](src/oop/abstraction/) | Abstract classes vs interfaces | [ ] |

### 2. Data Structures & Algorithms (`src/dsa/`), 

| # | Topic | What it covers |
|---|-------|----------------|
| 2.1 | Big-O | Time and space complexity |
| 2.2 | Arrays | `int[]`, `ArrayList`, access vs insert costs |
| 2.3 | Hash maps / sets | `HashMap`, `HashSet`, average vs worst case |
| 2.4 | Stack & Queue | `ArrayDeque`, LIFO vs FIFO |
| 2.5 | Linked List | Nodes, insert/delete, traversal |
| 2.6 | Recursion | Base case, call stack |
| 2.7 | Binary Search | Halving a sorted search space |
| 2.8 | Sorting | Merge sort, quicksort |
| 2.9 | Trees / BST | Nodes, search, insert |
| 2.10 | DFS & BFS | Depth-first vs breadth-first traversal |
| 2.11 | Heap | `PriorityQueue`, min-heap |
| 2.12 | Graphs | Adjacency list representation |

## How each folder is organized

- `Main.java`: runnable example (click **Run** above `main` in VS Code)
- `NOTES.md`: one-sentence definition, core rule, common mistakes,
  my own example, and a spoken interview answer

## How to run

### Option A: VSCode
1. Open any `Main.java`.
2. Click **Run** above the `main` method.


### Option B: Terminal (`javac` + `java`)
Run all commands from the **repo root** (the folder that contains `src/`).

**Compile** a topic's files into a `bin/` folder:

```bash
javac -d bin src/oop/encapsulation/*.java
```

**Run** it using the full package name (not the file path):

```bash
java -cp bin oop.encapsulation.Main
```
