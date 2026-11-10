package dsa.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// ================= MIN-HEAP FROM SCRATCH =================
class MinHeap {
    private final List<Integer> data = new ArrayList<>();

    public int peek() {
        return data.get(0);                     // root is ALWAYS at index 0: O(1)
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // INSERT or OFFER: add at the end, O(log n)
    public void insert(int val) {
        data.add(val);
        int i = data.size() - 1;

        while (i > 0) {
            int parent = (i - 1) / 2;

            if (data.get(i) < data.get(parent)) {
                swap(i, parent);
                i = parent;                        // keep climbing
            } else {
                break;                             // parent is smaller: heap rule holds
            }
        }
    }

    // POLL: take the root, move the LAST element to the root, O(log n)
    public int poll() {
        int min = data.get(0);
        int last = data.remove(data.size() - 1);

        if (!data.isEmpty()) {
            data.set(0, last);
            int i = 0;

            while (true) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int smallest = i;

                if (left < data.size() && data.get(left) < data.get(smallest)){ 
                    smallest = left;
                }
                if (right < data.size() && data.get(right) < data.get(smallest)){
                smallest = right;
                }
                if (smallest == i){     // both children bigger: done
                    break;              
                }          
                swap(i, smallest);                 // swap with the SMALLER child
                i = smallest;
            }
        }
        return min;
    }

    private void swap(int i, int j) {
        int tmp = data.get(i);
        data.set(i, data.get(j));       // replace element at position with the specified element
        data.set(j, tmp);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

public class Main {
    public static void main(String[] args) {

        // ================= 1. MY HEAP, STEP BY STEP =================
        System.out.println("My Heap");
        System.out.println("Min-Heap");
        MinHeap heap = new MinHeap();
        for (int v : new int[]{50, 30, 70, 20, 40, 10}) {
            heap.insert(v);
            System.out.println("Insert " + v + " -> " + heap + "\n");
        }
        
        System.out.println("Peek root:");
        System.out.println("Peek: " + heap.peek());
        while (!heap.isEmpty()) {
            int v = heap.poll();
            System.out.println("Poll " + v + " -> " + heap + "\n");
        }

        // ================= 2. JAVA'S PriorityQueue (a min-heap by default) =================
        System.out.println("Java's PriorityQueue");
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int v : new int[]{50, 30, 70, 20, 40, 10}) {
            minPQ.offer(v);
            System.out.println("Insert " + v + " -> " + minPQ + "\n");
        }
        System.out.println("Printed PQ (NOT sorted!): " + minPQ);
        System.out.print("Polled in order: ");
        while (!minPQ.isEmpty()) {
            System.out.print(minPQ.poll() + " ");
        }
        System.out.println();

        // ================= 3. MAX-HEAP: reverse the order =================
        System.out.println();
        System.out.println("Max-Heap: reverse the order");
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int v : new int[]{50, 30, 70, 20, 40, 10}) {
            maxPQ.offer(v);
        }
        System.out.println("Max-heap poll: " + maxPQ.poll() + "\n");

        // ================= 4. TOP K LARGEST: min-heap of size k =================
         System.out.println("Top K largest: min-heap of size k");
        int[] nums = {5, 1, 9, 3, 7, 2, 8};
        int k = 3;
        PriorityQueue<Integer> topK = new PriorityQueue<>();
        for (int n : nums) {
            topK.offer(n);
            System.out.println("Insert " + n + " -> " + topK + "\n");

            if (topK.size() > k) {
                topK.poll();                       // kick out the smallest
            }
        }
        List<Integer> result = new ArrayList<>(topK);
        Collections.sort(result);
        System.out.println(k + " largest: " + result);
        System.out.println(k + "rd largest: " + topK.peek());
    }
}