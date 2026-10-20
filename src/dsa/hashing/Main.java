package dsa.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    // ================= CLASSIC PATTERN: Two Sum =================
    // For each number, check if its "partner" was already seen. O(n) instead of O(n^2).
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();   // value → index
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            if (seen.containsKey(sum)) {               // O(1) lookup
                return new int[]{seen.get(sum), i};
            }
            seen.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {

        // ================= HashMap: KEY → VALUE =================
        // Pattern: counting (used in Valid Anagram, Top K Frequent).
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};

        System.out.println("List of words: " +  Arrays.toString(words) + "\n");

        Map<String, Integer> counts = new HashMap<>();
        for (String w : words) {
            counts.put(w, counts.getOrDefault(w, 0) + 1);   // 0 if the key isn't there yet
        }

        System.out.println("apple count: " + counts.get("apple"));       // get: O(1) average
        System.out.println("banana count: " + counts.get("banana"));
        System.out.println("grape count: " + counts.get("grape") + "\n");       // missing key → null
        System.out.println("grape count (default): " + counts.getOrDefault("grape", 0) + "\n");
        System.out.println("Has banana? " + counts.containsKey("banana") + "\n");
        System.out.println("Unique words count: " + counts.size() + "\n");

        counts.put("apple", 10);                                    // same key → OVERWRITES
        System.out.println("apple after put 10: " + counts.get("apple") + "\n");

        // ================= HashSet: UNIQUE VALUES ONLY =================
        // Pattern: "have I seen this before?" (Contains Duplicate).
        int[] data = {4, 7, 1, 7, 9};
        System.out.println("List of data numbers: " + Arrays.toString(data) + "\n");
        
        Set<Integer> seen = new HashSet<>();
        for (int x : data) {
            if (!seen.add(x)) {          // add() returns FALSE if x was already there
                System.out.println("Duplicate found: " + x);
                break;
            }
        }
        System.out.println("Seen size: " + seen.size() + "\n");

        // ================= Two Sum =================
        System.out.println("For Two Sum problem: ");
        System.out.println("nums: [2,7,11,15]");
        System.out.println("target = 9");
        System.out.println("Two Sum: " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)) + "\n");
    }
}
