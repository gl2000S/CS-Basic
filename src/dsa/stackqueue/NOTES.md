# Stack & Queue

## In one sentence
A stack removes the MOST RECENT item first (LIFO, like plates).
A queue removes the OLDEST item first (FIFO, like a line).

## Why it matters
- Stack: matching brackets, undo, reversing, DFS, "most recent" problems.
- Queue: processing in arrival order, scheduling, BFS (level by level).
- Both do their core operations in O(1).

## The core rule
Same 3 items in (A, B, C, D):
- Stack → comes out D, C, B, A
- Queue → comes out A, B, C, D

## Java: use ArrayDeque for both
|             | Stack                                   | Queue |
|---          |---                                      |---|
| Declare     | `Deque<T> s = new ArrayDeque<>();`      | `Queue<T> q = new ArrayDeque<>();` |
| Add         | push(x) (to top)                        | offer(x) (to back) |
| Remove      | pop() (from top)                        | poll() (from front) |
| Look        | peek() (top)                            | peek() (front) |
| Cost        | O(1)                                    | O(1) |

Don't use java.util.Stack: it extends Vector, so it inherits list methods that break LIFO (see composition notes).

## Empty behavior
| Method            | On empty |
|---                |---|
| peek(), poll()    | return null |
| pop()             | throws NoSuchElementException |
Always check isEmpty() before pop() or poll().

## Patterns
- Matching pairs → stack 
- Track a running value per level → stack of pairs 
- "Next greater/warmer" element → monotonic stack 
- Level-by-level traversal → queue 


## Interview answer
A stack is last in, first out: 
push and pop both happen at the top, like a stack of plates. 
A queue is first in, first out: 
add at the back,remove from the front, like a line. 
Both have O(1) core operations. 
In Java, use ArrayDeque for both instead of the Stack class. 