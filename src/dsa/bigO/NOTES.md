# Big O

## In one sentence
Big O describes how an algorithm's running time (or memory) GROWS as the input size n grows, ignoring constants.

## Why it matters
- Let compare solutions without running them.
- Every interview solution ends with: "What's the time and space complexity?"

## The core rule
Count how the work scales with n, then simplify:
- Drop constants:            2n → O(n);  n^2 / 2 → O(n^2)
- Drop smaller terms:        n^2 + n → O(n^2)
- Sequential steps ADD:      loop, then loop → O(n + n) = O(n)
- Nested steps MULTIPLY:     loop inside loop → O(n * n) = O(n^2)
- Halving each step:         → O(log n)
- Different inputs, different letters: loop over a, then b → O(a + b)

## Common complexities (fastest → slowest)
| Big O             | Name          | Example                       | n=1000 steps |
|---                |---            |---                            |---|
| O(1)              | Constant      | arr[i], HashMap.get           | 1 |
| O(log n)          | Logarithmic   | Binary search                 | ~10 |
| O(n)              | Linear        | One loop over the array       | 1,000 |
| O(n log n)        | Linearithmic  | Merge sort, Arrays.sort       | ~10,000 |
| O(n^2)            | Quadratic     | Nested loops over all pairs   | ~1,000,000 |
| O(2^n)            | Exponential   | Naive recursive Fibonacci     | (n=1000: never finishes) |

## How to analyze code
1. What is n? (array length, string length, number of nodes...)
2. Count the loops: 
    - one loop → n; 
    - nested → multiply; 
    - halving → log n.
3. Recursion: (calls per level)^(depth). fib makes 2 calls, depth n → 2^n.
4. Simplify: drop constants and smaller terms.
5. Default to the WORST case unless asked otherwise.

## Space complexity
- Same idea, for EXTRA memory used (not counting the input).
- Summing an array with one variable → O(1) space.
- Copying the array or filling a HashSet with n items → O(n) space.
- Recursion uses the call stack: depth d → O(d) space.


## Interview answer
Big O describes how an algorithm's time or memory grows as the input grows. 
Find it by counting loops: 
    - a single loop is O(n), 
    - nested loops multiply to O(n^2), 
    - and halving the search space each step, like binary search, is O(log n). 
Drop constants and smaller terms, so 2n + 5 is O(n). For example, checking for duplicates with nested loops is O(n^2), but using a HashSet makes it O(n) time with O(n) extra space."