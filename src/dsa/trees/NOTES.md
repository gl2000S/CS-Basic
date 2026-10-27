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

## The three DFS traversals
| Traversal     | Order             | Root position         | Use |
|---            |---                |---                    |---|
| Preorder      | node, left, right | First                 | Copy/serialize a tree |
| Inorder       | left, node, right | Middle                | BST → sorted order |
| Postorder     | left, right, node | Last                  | Children's answers first (max depth, size) |

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

## Costs
| Operation | Balanced BST | Skewed BST |
|---|---|---|
| Search / insert / delete | O(log n) | O(n) |
| Min / max | O(log n) | O(n) |
| Inorder traversal | O(n) | O(n) |
| Recursion space | O(log n) | O(n) |

## Common mistakes
- Calling insert(root.left, val) without assigning → node never attached.
- Validating a BST with only parent-child checks → misses deeper violations.
- int bounds in validation → fails on Integer.MIN/MAX_VALUE nodes.
- Assuming a BST is always O(log n): sorted inserts make it O(n).


## Interview answer
A tree is a hierarchy of nodes;
A binary search tree keeps every value in a node's left subtree smaller and every value in its right subtree larger. 
That lets search and insert skip half the tree at each step:
O(log n) if balanced, but O(n) if it degrades into a line, like when inserting sorted values.
Most tree problems use recursion: handle the null base case, solve the left and right subtrees, then combine, like max depth = 1 + max(left, right).