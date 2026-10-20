# Arrays

## In one sentence
An array stores elements in one continuous block of memory, so any index can be reached instantly, but the size is fixed and inserting in the middle means shifting.

## The core rule
- Access by index: O(1), because Java computes address directly.
- Insert/delete in the middle: O(n), because elements must shift.
    - insert 15 at index 1 of [10, 20, 30, 40] → 3 shifts
- Search for a value (unsorted): O(n), checking one by one.

## int[] vs ArrayList
|           | int[]                     | ArrayList<Integer> |
|---        |---                        |---|
| Size      | Fixed at creation         | Grows automatically |
| Holds     | Primitives or objects     | Objects only (Integer, not int) |
| Length    | `arr.length` (field)      | `list.size()` (method) |
| Print     | `Arrays.toString(arr)`    | `println(list)` works directly |

## Costs
| Operation                     | int[]         | ArrayList |
|---                            |---            |---|
| get/set by index              | O(1)          | O(1) |
| add at end                    | can't grow    | O(1) |
| add/remove at front or middle | O(n) shift    | O(n) shift |
| contains / search             | O(n)          | O(n) |


## Common mistakes
- Printing an array directly → [I@1b6d3586 (use Arrays.toString).
- Index out of bounds: valid indexes are 0 to length - 1.
- list.remove(1) removes INDEX 1; list.remove(Integer.valueOf(1)) removes VALUE 1.
- Mixing up .length (arrays) and .size() (ArrayList).


## Interview answer
Arrays store elements contiguously, 
so access by index is O(1), 
but inserting or deleting in the middle is O(n) because elements shift.
Java arrays have a fixed size; 
ArrayList wraps an array that resizes automatically. 