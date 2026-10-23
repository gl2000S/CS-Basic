package dsa.linkedlist;

// A NODE holds a value and a REFERENCE to the next node.
// Why not linkedlist = hides the nodes 
public class ListNode {
    int val;
    ListNode next;          // null means "end of the list"

    ListNode(int val) {
        this.val = val;
    }
} 
