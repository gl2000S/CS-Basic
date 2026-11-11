# Trees & Binary Search Trees

## In one sentence
A tree is a hierarchy of nodes where each node has children;
A binary search tree keeps smaller values on the left and larger on the right, so search can skip half the tree at each step.

## Vocabulary
| Term                  | Meaning |
|---                    |---|
| Root                  | Top node (no parent) |
| Leaf                  | Node with no children |
| Parent / child        | A node and the nodes directly below it |
| Subtree               | A node plus everything below it |
| Depth / height        | Number of nodes on the longest root-to-leaf path |
| Binary tree           | Each node has at most 2 children |
| BST                   | Binary tree where left subtree < node < right subtree, for EVERY node |
| Balanced              | Left and right heights stay close → height about log n |

## The core rule
- BST property applies to entire subtrees, not just direct children.
- Search/insert: compare, go left or right, repeat.
    Cost = O(height).
    Balanced: height ≈ log n → O(log n)
    Skewed (sorted inserts): height = n → O(n)

## The recursive template (most tree problems)
  - if (node == null) return BASE;          // empty tree
  - left  = solve(node.left);               // trust recursion for subtrees
  - right = solve(node.right);
  - return COMBINE(node, left, right);      // e.g. 1 + max(left, right)

## DFS: Depth-First Search
Go as deep as possible down one branch before backtracking.
Uses a STACK: the call stack (recursion) or my own Deque.

### The three DFS traversals
Identical code except WHEN the node is recorded ("pre/in/post" = position of the NODE).
| Traversal     | Order             | Root position         | Use |
|---            |---                |---                    |---|
| Preorder      | node, left, right | First                 | Copy/serialize a tree |
| Inorder       | left, node, right | Middle                | BST → sorted order |
| Postorder     | left, right, node | Last                  | Children's answers first (max depth, size) |

On my tree (inserted 50, 30, 70, 20, 40, 60, 80, 35):
  Preorder:  50, 30, 20, 40, 35, 70, 60, 80
  Inorder:   20, 30, 35, 40, 50, 60, 70, 80
  Postorder: 20, 35, 40, 30, 60, 80, 70, 50


## BFS: Breadth-First Search
Visit level by level: root, then everything 1 step away, then 2 steps..
Uses a QUEUE: nodes are processed in the order they were discovered.

On my tree:
  Level order: 50, 30, 70, 20, 40, 60, 80, 35
  Grouped:     [[50], [30, 70], [20, 40, 60, 80], [35]]


## DFS vs BFS
| | DFS | BFS |
|---|---|---|
| Container | Stack (or recursion) | Queue |
| Order | Deep down one branch first | Level by level |
| Good for | Paths, subtree answers (depth, validate) | Levels, shortest path in unweighted graphs |
| Space | O(h): height | O(w): widest level |
| Time | O(n) | O(n) |

Swapping Stack ↔ Queue in the same loop switches DFS ↔ BFS.

## Costs
| Operation | Balanced BST | Skewed BST |
|---|---|---|
| Search / insert / delete | O(log n) | O(n) |
| Min / max | O(log n) | O(n) |
| Any traversal (DFS or BFS) | O(n) | O(n) |
| Recursion space | O(log n) | O(n) |

## Interview answer
A tree is a hierarchy of nodes;
A binary search tree keeps every value in a node's left subtree smaller and every value in its right subtree larger.
That lets search and insert skip half the tree at each step:
O(log n) if balanced, but O(n) if it degrades into a line, like when inserting sorted values.
Most tree problems use recursion: handle the null base case, solve the left and right subtrees, then combine, like max depth = 1 + max(left, right).

To traverse a tree, DFS goes deep first using a stack or recursion: preorder, inorder, and postorder differ only in when the node is visited, and inorder on a BST gives sorted order.
BFS goes level by level using a queue; to group by level, record the queue's size at the start of each level.
Both are O(n) time; DFS uses O(h) space and BFS uses O(w), the widest level.