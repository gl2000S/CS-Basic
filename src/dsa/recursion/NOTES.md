# Recursion

## In one sentence
A method that solves a problem by calling itself on a SMALLER version of the same problem, until it reaches a case simple enough to answer directly.

## The core rule
Every recursive method needs:
1. BASE CASE: when to stop (n <= 1, index == length, node == null) 
2. RECURSIVE CASE: call itself on a smaller input that moves TOWARD the base
    EX: factorial(4) = 4 * factorial(3) = 4 * 3 * factorial(2) = ... = 24

## The call stack
- Each call waits on the stack until the call it made returns.
- Calls go DOWN until the base case, then answers come back UP.
- Too deep or no base case → StackOverflowError.

## Memo
- Store answers to subproblems in a HashMap; reuse instead of recompute.
- fib(25): naive = 242,785 calls (O(2^n)); memo = 49 calls (O(n)).
- This is the foundation of dynamic programming.

## Recursion vs iteration
|               | Recursion                             | Iteration (loops) |
|---            |---                                    |---|
| Best for      | Trees, nested/branching structures    | Simple repeated steps |
| Extra space   | O(depth) call stack                   | Usually O(1) |
| Risk          | StackOverflowError on deep input      | Infinite loop |


## Common mistakes
- Missing base case → StackOverflowError.
- Recursive call that doesn't move toward the base (n + 1 instead of n - 1).
- Forgetting to RETURN the recursive result (calling it but ignoring it).
- Naive recursion with overlapping subproblems → exponential time

## Interview answer
Recursion is when a function solves a problem by calling itself on a smaller version of it. 
It needs a base case to stop and a recursive case that moves toward it.
Each call sits on the call stack until its subcall returns, so recursion uses O(depth) space.
When subproblems repeat, like naive Fibonacci, memoize results in a map, which turns exponential into linear. 
It's especially natural for trees, where each node's answer depends on its left and right subtrees.