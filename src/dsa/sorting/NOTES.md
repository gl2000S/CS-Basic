# Sorting

## In one sentence
Sorting arranges elements in order; simple sorts compare neighbors in O(n^2), while divide-and-conquer sorts like merge sort reach O(n log n).

## The algorithms
| Algorithm | Idea | Best | Average | Worst | Extra space | Stable? |
|---|---|---|---|---|---|---|
| Bubble | Swap out-of-order neighbors | O(n^2)* | O(n^2) | O(n^2) | O(1) | Yes |
| Merge | Split, sort halves, merge | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| Quick | Partition around pivot, recurse | O(n log n) | O(n log n) | O(n^2) | O(log n) avg | No |

*O(n) with an early-exit check when no swaps happen.

"Stable" = equal elements keep their original order.

## Why n log n for merge sort
- Splitting in half repeatedly → log n levels.
- Each level merges all n elements → n work per level.
- n per level * log n levels = O(n log n).

## Quicksort's weakness
- A bad pivot (e.g. last element on already-sorted or reversed input) → lopsided partitions → O(n^2). Fix: random or median-of-three pivot.

## Common mistakes
- Saying quicksort is always O(n log n): its worst case is O(n^2).
- Forgetting arrays are passed by reference: sorting inside a method changes the caller's array (clone() for a copy).
- Off-by-one in merge: i <= mid, j <= right (inclusive bounds).


## Interview answer
Simple sorts like bubble sort compare neighbors and run in O(n^2).
Merge sort splits the array in half, recursively sorts each half, and merges them, giving O(n log n) in every case with O(n) extra space, and it's stable. 
Quicksort partitions around a pivot and is O(n log n) on average with little extra space, but degrades to O(n^2) with bad pivots.
In practice, use Arrays.sort, and often sort first to enable two pointers or binary search.