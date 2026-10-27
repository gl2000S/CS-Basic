package dsa.binarysearch;

import java.util.Arrays;

public class Main {

    // ================= ITERATIVE BINARY SEARCH =================
    // REQUIRES a SORTED array. Halve the search range every step: O(log n).
    public static int binarySearch(int[] arr, int target, boolean trace) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
    
            if (trace) {
                System.out.println("  left = " + left + " mid = " + mid + " right = " + right + " -> arr[mid] = " + arr[mid]);
            }

            if (arr[mid] == target) {
                return mid;                     // found
            } else if (arr[mid] < target) {
                left = mid + 1;                  // target is in the RIGHT half
            } else {
                right = mid - 1;                 // target is in the LEFT half
            }
        }
        return - 1;                              // range empty: not found
    }

    // ================= RECURSIVE BINARY SEARCH =================
    // Same logic: base case = empty range; recursive case = search one half.
    public static int binarySearchRec(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;

        } else if (arr[mid] < target) {
            return binarySearchRec(arr, target, mid + 1, right);

        } else {
            return binarySearchRec(arr, target, left, mid - 1);
        }
    }

    // ================= VARIATION: FIRST OCCURRENCE =================
    // With duplicates, keep searching LEFT after a match.
    public static int firstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                answer = mid;          // record it...
                right = mid - 1;        // ...but keep looking left

            } else if (arr[mid] < target) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Insert in an array in this order: 1, 3, 5, 7, 9, 11, 13, 15, 17, 19" + "\n");
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        System.out.println("Search for 13:");
        System.out.println("Result: " + binarySearch(arr, 13, true));

        System.out.println();
        System.out.println("Searching for 4:");
        System.out.println("Result: " + binarySearch(arr, 4, true));
        System.out.println("-1 = 'Not found' " + "\n");

        System.out.println("Recursive Binary Search");
        System.out.println("Recursive search for 7: " + binarySearchRec(arr, 7, 0, arr.length - 1));

        System.out.println();
        int[] dups = {1, 2, 2, 2, 3};
        System.out.println("Standard search for 2 in " + Arrays.toString(dups) + ": " + binarySearch(dups, 2, false));
        System.out.println("left = 0 and right = 4 → mid = 0 + (4 - 0) / 2 = 2 → arr[2] = 2 → match → return 2");
        
        System.out.println();
        System.out.println("First occurrence of 2: " + firstOccurrence(dups, 2));
        System.out.println("left = 0 right = 4 → mid = 2 → arr[2]=2 → match! answer=2, keep looking left: high=1\n" + //
                        "left = 0 right = 1 → mid = 0 → arr[0]=1 → too small: low=1\n" + //
                        "left = 1 right = 1 → mid = 1 → arr[1]=2 → match! answer=1, keep looking left: high=0\n" + //
                        "left = 1 right = 0 → range empty, stop → return answer = 1\n");

        // Binary search on an UNSORTED array gives wrong answers.
        System.out.println("Binary search on an UNSORTED array");
        System.out.println("Unsorted Array: 5, 1, 9, 3");
        int[] unsorted = {5, 1, 9, 3};
        System.out.println("Arrays.binarySearch on UNSORTED array: " + Arrays.binarySearch(unsorted, 3));
        System.out.println("left = 0 right = 3 → mid = 1 → arr[1]=1 → 1 < 3, go right: left = 2\n" + //
                        "left = 2 right = 3 → mid = 2 → arr[2]=9 → 9 > 3, go left:  right = 1\n" + //
                        "left = 2 right = 1 → range empty, stop.\n" + //
                        "Insertion point = left = 2\n" + //
                        "result = -(2) - 1 = -3\n");
        
    }
}