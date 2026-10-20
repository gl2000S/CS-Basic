package dsa.bigO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // We use LONG variables to count steps, since it could get large.

    // ================= O(1): CONSTANT =================
    // Same work no matter how big the array is.
    static long constant(int[] arr) {
        long steps = 0;
        int first = arr[0];   // one step
        steps++;
        return steps;
    }

    // ================= O(log n): LOGARITHMIC =================
    // Binary search: the search space HALVES every step.
    // Searching for a value larger than everything = worst case.
    static long logarithmic(int[] arr) {
        long steps = 0;
        int target = arr.length;   // not in array (arr holds 0..n-1)
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            steps++;
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;     // throw away left half
            } else {
                right = mid - 1;    // throw away right half
            }
        }
        return steps;
    }

    // ================= O(n): LINEAR =================
    // Touch every element once.
    static long linear(int[] arr) {
        long steps = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            steps++;
        }
        return steps;
    }

    // ================= O(n log n): LINEARITHMIC =================
    // For EACH element (n), do a halving loop (log n).
    // Same growth as merge sort and Arrays.sort.
    static long linearithmic(int[] arr) {
        long steps = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {           // n times
            for (int j = n; j > 1; j /= 2) {    // log n times
                steps++;
            }
        }
        return steps;
    }

    // ================= O(n^2): QUADRATIC =================
    // Brute-force duplicate check: compare every PAIR.
    // j starts at i + 1, so it's about n^2 / 2 steps, still O(n^2).
    static long quadratic(int[] arr) {
        long steps = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) { 
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    // duplicate found (never happens here: values are unique)
                }
                steps++;
            }
        }
        return steps;
    }

    // ================= O(2^n): EXPONENTIAL =================
    // Recursive Fibonacci: each call makes TWO more calls.
    static long calls = 0;

    static long fib(int n) {
        calls++;
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // Helper: array holding 0, 1, 2, ..., n-1 (sorted, no duplicates)
    static int[] makeArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000};

        System.out.printf("%n%-12s %10s %10s %10s %n", "Complexity", "n=10", "n=100", "n=1000");

        long[] row = new long[3];

        for (int k = 0; k < sizes.length; k++){
            row[k] = constant(makeArray(sizes[k]));
        }
        System.out.printf("%-12s %10d %10d %10d %n", "O(1)", row[0], row[1], row[2]);   

        for (int k = 0; k < sizes.length; k++){
            row[k] = logarithmic(makeArray(sizes[k]));
        }
        System.out.printf("%-12s %10d %10d %10d %n", "O(log n)", row[0], row[1], row[2]);

        

        for (int k = 0; k < 3; k++) {
            row[k] = linear(makeArray(sizes[k]));
        }
        System.out.printf("%-12s %10d %10d %10d %n", "O(n)", row[0], row[1], row[2]);

        

        for (int k = 0; k < 3; k++) {
            row[k] = linearithmic(makeArray(sizes[k]));
        }
        System.out.printf("%-12s %10d %10d %10d %n", "O(n log n)", row[0], row[1], row[2]);
        

        for (int k = 0; k < 3; k++) {
            row[k] = quadratic(makeArray(sizes[k]));
        }
        System.out.printf("%-12s %10d %10d %10d %n", "O(n^2)", row[0], row[1], row[2]);

        

        // Exponential: n = 1000 would never finish.
        System.out.println();
        System.out.println("O(2^n) naive Fibonacci:");
        int[] fibSizes = {10, 20, 25};
        for (int n : fibSizes) {
            calls = 0;
            fib(n);
            System.out.println("n = " + n + ": " + calls + " calls");
        }
    }
}
