# Heap

## In one sentence
A heap is a complete binary tree stored in an array where every parent is smaller than its children (min-heap), so the smallest value is always at the root and can be removed in O(log n).

## The core rule
- Min-heap: parent <= children. 
- Max-heap: parent >= children.
- Only parent-child order matters, siblings are NOT ordered.
- Root = min (or max).
- Index math (array storage, no pointers): 
parent = (i - 1) / 2,  
left = 2i + 1,  
right = 2i + 2

## Operations
| Operation | How | Cost |
|---|---|---|
| peek | Read index 0 | O(1) |
| insert / offer | Add at end, SIFT UP while smaller than parent | O(log n) |
| poll | Take root, move last to root, SIFT DOWN to smaller child | O(log n) |
| Search for any value | No ordering to use → check everything | O(n) |
| Build from n values | Heapify | O(n) |

## Heap vs BST vs sorted array
| | Heap | BST (balanced) | Sorted array |
|---|---|---|---|
| Get min | O(1) | O(log n) | O(1) |
| Remove min | O(log n) | O(log n) | O(n) (shift) |
| Insert | O(log n) | O(log n) | O(n) (shift) |
| Search any value | O(n) | O(log n) | O(log n) |
Use a heap when you repeatedly need the min (or max), not general search.


## Java: PriorityQueue
| Code | Type | peek() / poll() gives |
|---|---|---|
| `new PriorityQueue<>()` | Min-heap (default) | Smallest |
| `new PriorityQueue<>((a, b) -> Integer.compare(a, b))` | Min-heap (same as default, written out) | Smallest |
| `new PriorityQueue<>(Collections.reverseOrder())` | Max-heap | Largest |
| `new PriorityQueue<>((a, b) -> Integer.compare(b, a))` | Max-heap | Largest |

- The comparator answers "which comes first?": negative → a first,
  positive → b first. Swapping a and b flips min-heap ↔ max-heap.
- Avoid `(a, b) -> b - a`: overflows with extreme values (Integer.MIN_VALUE).
- offer(x), poll() (null if empty), peek() (null if empty), size(), isEmpty()
- Printing it shows ARRAY order, not sorted order.


## Interview answer
A heap is a complete binary tree stored in an array, where in a min-heap every parent is smaller than its children, so the minimum is always at the root.
peek is O(1), and insert and remove are O(log n) because values shift up or down one level at a time.
In Java use PriorityQueue, which is a min-heap by default.
A classic use is finding the k largest elements: keep a min-heap of size k and evict the smallest whenever it grows past k, giving O(n log k).
