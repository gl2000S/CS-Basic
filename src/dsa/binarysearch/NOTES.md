# Binary Search

## In one sentence
Find a target in a SORTED array by checking the middle and throwing away the half that can't contain it, so the work is O(log n).

## The core rule
- The array MUST be sorted.
- left = 0, right = n - 1; loop while left <= right.
- mid = left + (right - left) / 2
- arr[mid] < target → left = mid + 1 (go right)
- arr[mid] > target → right = mid - 1 (go left)
- Range empty (left > right) → not found, return -1.

## Variations 
- First/last occurrence: on a match, record it and keep searching left/right.
- Search on the ANSWER: binary search over possible answers, not the array.
- Rotated sorted array: one half is always sorted; decide which side the target is on.

## Complexity
- Time: O(log n)
- Space: O(1) iterative; O(log n) recursive (call stack)

## Common mistakes
- Using it on an unsorted array.
- while (left < right) instead of left <= right → misses the last element.
- left = mid instead of mid + 1 → infinite loop.
- Using (left + right) / 2 → overflow on huge arrays.

## Interview answer
Binary search finds a target in a sorted array by repeatedly checking the middle element and discarding the half that can't contain it, which gives O(log n) time and O(1) space iteratively. 
Compute mid as left + (right - left) / 2 to avoid overflow and loop while low <= high.
Variations include finding the first occurrence of a duplicate and binary searching over possible answers instead of the array itself.