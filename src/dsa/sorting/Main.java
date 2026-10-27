package dsa.sorting;

import java.util.Arrays;

public class Main {

    // ================= BUBBLE SORT: O(n^2) =================
    // Repeatedly swap neighbors that are out of order.
    // After each pass, the largest remaining value "bubbles" to the end.
    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {   // last i items are already in place
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    // ================= MERGE SORT: O(n log n) =================
    // Split in half, sort each half (recursively), merge the two sorted halves.
    public static void mergeSort(int[] a, int left, int right) {
        if (left >= right) {
            return;                             // base case: 0 or 1 element is sorted
        }
        int mid = left + (right - left) / 2;
        mergeSort(a, left, mid);                // sort left half
        mergeSort(a, mid + 1, right);           // sort right half
        merge(a, left, mid, right);             // combine
    }

    public static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;        // pointer into left half
        int j = mid + 1;     // pointer into right half
        int k = 0;           // pointer into temp
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];             // take the smaller front element
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) temp[k++] = a[i++];    // copy leftovers
        while (j <= right) temp[k++] = a[j++];
        for (k = 0; k < temp.length; k++) {
            a[left + k] = temp[k];              // copy back
        }
    }

    // ================= QUICKSORT: O(n log n) average, O(n^2) worst =================
    // Pick a pivot, put smaller values left of it and larger right, recurse on each side.
    public static void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = partition(a, low, high);
        quickSort(a, low, p - 1);
        quickSort(a, p + 1, high);
    }

    public static int partition(int[] a, int low, int high) {
        int pivot = a[high];                    // last element as pivot
        int i = low;                            // next spot for a "smaller" value
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, high);                       // pivot goes into its final position
        return i;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        // 1. All methods on the same small array (copy so each starts unsorted)
        System.out.println("All methods on the same small array.\n");
        System.out.println("Array: 5, 2, 9, 1, 7, 3");
        int[] original = {5, 2, 9, 1, 7, 3};

        int[] b = original.clone();
        bubbleSort(b);
        System.out.println("Bubble:      " + Arrays.toString(b));
        System.out.println("j=0: 5 > 2? yes → swap → [2, 5, 9, 1, 7, 3]\n" + //
                        "j=1: 5 > 9? no       → [2, 5, 9, 1, 7, 3]\n" + //
                        "j=2: 9 > 1? yes → swap → [2, 5, 1, 9, 7, 3]\n" + //
                        "j=3: 9 > 7? yes → swap → [2, 5, 1, 7, 9, 3]\n" + //
                        "j=4: 9 > 3? yes → swap → [2, 5, 1, 7, 3, 9]   ← 9 is in its final spot\n");

        int[] m = original.clone();
        mergeSort(m, 0, m.length - 1);
        System.out.println("Merge:       " + Arrays.toString(m));
        System.out.println("                [5, 2, 9, 1, 7, 3]\n" + //
                        "               /                  \\\n" + //
                        "        [5, 2, 9]                [1, 7, 3]\n" + //
                        "        /       \\                /       \\\n" + //
                        "    [5, 2]     [9]           [1, 7]     [3]\n" + //
                        "    /    \\                   /    \\\n" + //
                        "  [5]    [2]               [1]    [7]");

        System.out.println("[5] + [2]       → [2, 5]\n" + //
                        "[2, 5] + [9]    → [2, 5, 9]\n" + //
                        "[1] + [7]       → [1, 7]\n" + //
                        "[1, 7] + [3]    → [1, 3, 7]\n" + //
                        "[2, 5, 9] + [1, 3, 7] → final merge (below)\n");


        int[] q = original.clone();
        quickSort(q, 0, q.length - 1);
        System.out.println("Quick:       " + Arrays.toString(q));
        System.out.println("Start:           [5, 2, 9, 1, 7, 3]   i=0\n" + //
                        "j=0: 5 < 3? no                         i=0\n" + //
                        "j=1: 2 < 3? yes → swap a[0], a[1] → [2, 5, 9, 1, 7, 3]   i=1\n" + //
                        "j=2: 9 < 3? no                         i=1\n" + //
                        "j=3: 1 < 3? yes → swap a[1], a[3] → [2, 1, 9, 5, 7, 3]   i=2\n" + //
                        "j=4: 7 < 3? no                         i=2\n" + //
                        "End: swap a[2] with pivot a[5]  → [2, 1, 3, 5, 7, 9]   return p=2\n");

        int[] s = original.clone();
        Arrays.sort(s);                          // what you use in real code
        System.out.println("Arrays.sort: " + Arrays.toString(s) + "\n");


        // 2. Sorting objects with a custom rule (COMPARATOR)
        System.out.println("Sorting objects with a custom rule: ");
        System.out.println("Words: \"banana\", \"fig\", \"apple\", \"kiwi\"");
        String[] words = {"banana", "fig", "apple", "kiwi"};
        Arrays.sort(words, (x, y) -> x.length() - y.length());   // shorter first
        System.out.println("By length:   " + Arrays.toString(words));
        System.out.println("compare(\"banana\", \"fig\")  → 6 - 3 =  3  → positive → \"fig\" goes first\n" + //
                        "compare(\"fig\", \"kiwi\")    → 3 - 4 = -1  → negative → \"fig\" stays first\n" + //
                        "compare(\"apple\", \"kiwi\")  → 5 - 4 =  1  → positive → \"kiwi\" goes first\n");


/**                         
        // 3. Timing: n^2 vs n log n on 20,000 reversed numbers
        int n = 20000;
        int[] big = new int[n];
        for (int i = 0; i < n; i++) big[i] = n - i;   // worst case for bubble

        int[] t1 = big.clone();
        long start = System.nanoTime();
        bubbleSort(t1);
        System.out.println("Bubble sort: " + (System.nanoTime() - start) / 1_000_000
                + " ms, sorted=" + isSorted(t1));

        int[] t2 = big.clone();
        start = System.nanoTime();
        mergeSort(t2, 0, n - 1);
        System.out.println("Merge sort:  " + (System.nanoTime() - start) / 1_000_000
                + " ms, sorted=" + isSorted(t2));

        int[] t3 = big.clone();
        start = System.nanoTime();
        Arrays.sort(t3);
        System.out.println("Arrays.sort: " + (System.nanoTime() - start) / 1_000_000
                + " ms, sorted=" + isSorted(t3));
*/

    }
}