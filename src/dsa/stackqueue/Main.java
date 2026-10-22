package dsa.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Main {

    // ================= CLASSIC STACK PROBLEM: Valid Parentheses =================
    // Every closing bracket must match the MOST RECENT unmatched opening bracket.
    // "Most recent" = last in, first out = stack.
    static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);                                                                                  // opening bracket: save for later
            }
            else if (stack.isEmpty()) {
                return false;                                                                                   // closing bracket with nothing to match
            }
            else {
                char top = stack.pop();                                                                         // most recent opener
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false;                                                                               // wrong type
                }
            }
        }
        return stack.isEmpty();                                                                                // leftovers = unmatched openers
    }

    public static void main(String[] args) {

        // ================= STACK: LIFO (Last In, First Out) =================
        // Like a stack of plates: add to the top, take from the top.
        Deque<String> history = new ArrayDeque<>();
        System.out.println();
        System.out.println("Add to stack(In this order): 'open file' , 'type hello' , 'delete word'");
        history.push("open file");
        history.push("type hello");
        history.push("delete word");
        
        System.out.println("Stack: " + history);                       // top is printed FIRST
        System.out.println("Stack Peek: " + history.peek());           // look at the top, don't remove
        System.out.println("Stack Undo(pop): " + history.pop());       // remove the top
        System.out.println("Stack now: " + history);
        System.out.println("Stack Undo(pop): " + history.pop());
        System.out.println("Stack now: " + history + "\n");

        // ================= QUEUE: FIFO (First In, First Out) =================
        // Like a line at a counter: join at the back, served from the front.
        Queue<String> line = new ArrayDeque<>();
        System.out.println();
        System.out.println("Add to QUEUE(In this order): 'Ana' , 'Ben' , 'Cal'");
        line.offer("Ana");
        line.offer("Ben");
        line.offer("Cal");

        System.out.println("Queue: " + line);
        System.out.println("Peek: " + line.peek());                 // who's next, don't remove
        System.out.println("Served (delete): " + line.poll());      // remove from the front
        System.out.println("Queue now: " + line);
        System.out.println("Served (delete): " + line.poll());
        System.out.println("Queue now: " + line);

        
        // ================= Valid Parentheses =================
        System.out.println();
        System.out.println("Tests: {\"()[]{}\", \"([)]\", \"((\", \"{[]}\" }");
        String[] tests = {"()[]{}", "([)]", "((", "{[]}"};
        for (String t : tests) {
            System.out.println("Is valid: ");
            System.out.println(t + " -> " + isValid(t) + "\n");
        }

        // ================= EMPTY BEHAVIOR: know which methods throw =================
        Deque<Integer> empty = new ArrayDeque<>();
        System.out.println();
        System.out.println("Test on empty. ");
        System.out.println("peek on empty: " + empty.peek());           // null, no crash
        System.out.println("poll on empty: " + empty.poll());           // null, no crash
        try {
            empty.pop();                                                // THROWS
        } catch (NoSuchElementException e) {
            System.out.println("pop on empty: NoSuchElementException");
        }
    }
}