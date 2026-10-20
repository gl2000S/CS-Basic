package dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    
    // Inserting into MIDDLE of an array means shifting everything after it.
    // Returns how many elements had to move.
    static int insertAt(int[] arr, int size, int index, int value) { 
        int shift = 0; 
        
        for (int i = size - 1; i >= index; i--) {   // walk BACKWARD from the end
            arr[i + 1] = arr[i];                    // move each element one slot right
            shift++;
        }
        arr[index] = value;
        return shift; 
    }

    public static void main(String[] args) { 
        
        // ================= int[]: FIXED-SIZE ARRAY =================
        int[] nums = new int[5];                // size fixed at 5, filled with 0s
        
        System.out.println("New nums array: " + Arrays.toString(nums));

        System.out.println("Adding numbers..\n");
        nums[0] = 10;
        nums[1] = 20;
        nums[2] = 30;
        nums[3] = 40;                                             // 4 slots used, 1 free
        System.err.println("List of nums: " + Arrays.toString(nums));
        System.out.println("Second num: " + nums[2]);             // ACCESS by index: O(1)
        System.out.println("Length of nums: " + nums.length + "\n");     // .length is a FIELD, no ()


        // INSERT in the middle: O(n) because of shifting
        System.out.println("We now use insertAt method: \n"
                        + "Size = 4\n"
                        + "Index = 1\n"
                        + "Value = 15"
        );
        
        int shifts = insertAt(nums, 4, 1, 15);
        System.out.println("Shifts made: " + shifts);
        System.out.println("Nums after the shift: " + Arrays.toString(nums) + "\n");


        // Arrays can't grow: index 5 doesn't exist
        System.out.println("We try to add at index 5, what should happen?");
        try {
            nums[5] = 99;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of bounds: " + e.getMessage());
        }

        // ================= ArrayList: RESIZABLE ARRAY =================
        // Backed by an array inside; grows automatically when full.
        System.out.println();
        System.out.println("Creating a new ArrayList: ");
        List<Integer> list = new ArrayList<>();  // List<int> won't compile: needs Integer
        
        System.out.println("List add 1");
        list.add(1);                             // add at END: O(1) amortized
        System.out.println("List add 2");
        list.add(2);
        System.out.println("List add 3");
        list.add(3);
        System.out.println("List add 99 at index 0");
        list.add(0, 99);                         // add at FRONT: O(n), everything shifts
        System.out.println("List: " + list + "\n");

        System.out.println("Get the number 2: " + list.get(2) + "\n");         // get by index: O(1)
        System.out.println("Check if the list has a 3: " + list.contains(3) + "\n");    // search: O(n), checks one by one

        // THE TRAP: remove(int) removes by INDEX, not by value
        System.out.println("Now we want to remove 1: ");
        list.remove(1);                          // removes INDEX 1 (the value 1)
        System.out.println(list);

        System.out.println("Now the same for 99: ");
        list.remove(Integer.valueOf(99));        // removes the VALUE 99
        System.out.println(list);

        System.out.print("What is the size of the list now them? ");
        System.out.println(list.size() + "\n");         // .size() is a METHOD, with ()


    }
}
