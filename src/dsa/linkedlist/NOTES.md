# Linked List

## In one sentence
A chain of nodes, each holding a value and a reference to the next node;
Easy to insert/remove at a known spot, but no instant access by index.

## The core rule
- head = first node; 
- last node's next = null.
- To reach index i, walk i steps from head: O(n).

## Linked list vs array
| Operation                         | Array / ArrayList | Linked list |
|---                                |---                |---|
| Access by index                   | O(1)              | O(n) (walk) |
| Insert/delete at front            | O(n) (shift)      | O(1) |
| Insert at end                     | O(1) amortized    | O(n) without a tail pointer |
| Insert/delete at a known node     | O(n) (shift)      | O(1) (relink) |
| Memory                            | Contiguous        | Scattered; extra space per node for next |

## Techniques 
- Reverse: prev / cur / next, and save next FIRST (Reverse Linked List)
- Dummy node: removes the "delete the head" special case (Remove Nth Node From End)
- Fast/slow pointers: fast moves 2, slow moves 1 → find middle, detect cycle (Linked List Cycle)

## Common mistakes
- Overwriting cur.next before saving it → rest of the list lost.
- while (cur != null) when you need to stop AT the last node → use while (cur.next != null).
- Calling .next on null → NullPointerException.
- Forgetting to return the NEW head after changes.

## Interview answer
A linked list is a chain of nodes where each node holds a value and a reference to the next.
Unlike an array, access by index is O(n) because you have to walk the chain, 
but inserting or deleting at a known node is O(1) since you only relink pointers. 
Common techniques are reversing with prev, cur, and next pointers, using a dummy node to simplify edge cases, and fast/slow pointers to find the middle or detect a cycle.