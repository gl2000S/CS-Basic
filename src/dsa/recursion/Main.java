package dsa.recursion;

import java.util.HashMap;
import java.util.Map;

public class Main {

    // ================= FACTORIAL with a visible CALL STACK =================
    // depth is only for indentation, so you can SEE calls stacking up.
    static int factorial(int n, int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "factorial(" + n + ") called");

        if (n <= 1) {                                   // BASE CASE: stop here
            System.out.println(indent + "base case -> 1");
            return 1;
        }

        int result = n * factorial(n - 1, depth + 1);   // RECURSIVE CASE: smaller problem
        System.out.println(indent + "factorial(" + n + ") returns " + result);
        return result;
    }

    // ================= RECURSION ON AN ARRAY =================
    // sum = this element + sum of the REST
    static int sum(int[] arr, int index) {
        if (index == arr.length) {
            return 0;                                   // base case: nothing left
        }
        return arr[index] + sum(arr, index + 1);
    }

    // ================= NAIVE vs MEMOIZED FIBONACCI =================
    static long calls = 0;

    static long fibNaive(int n) {
        calls++;
        if (n <= 1) {
            return n;
        }
        return fibNaive(n - 1) + fibNaive(n - 2);       // recomputes the same values
    }

    // MEMOIZATION: remember answers already computed.
    static long fibMemo(int n, Map<Integer, Long> memo) {
        calls++;
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);                         // already solved: reuse it
        }
        long result = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    // ================= NO BASE CASE =================
    static int noBase(int n) {
        return noBase(n - 1);                           // never stops
    }

    public static void main(String[] args) {

        System.out.println();
        int result = factorial(4, 0);
        System.out.println("Result: " + result + "\n");

        System.out.println("Sum: " + sum(new int[]{1, 2, 3, 4}, 0) + "\n");

        System.out.println("Calls = 0");
        calls = 0;
        System.out.println("Fib Naive = 25");
        long a = fibNaive(25);
        System.out.println("Naive fib = " + a + ", calls: " + calls + "\n");

        System.out.println("Calls = 0");
        calls = 0;
        System.out.println("Fib Memo = 25");
        long b = fibMemo(25, new HashMap<>());
        System.out.println("Memo fib = " + b + ", calls: " + calls + "\n");

        // Catching an Error is normally bad practice; this is only a demo.
        try {
            noBase(10);
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError: no base case");
        }
    }
}