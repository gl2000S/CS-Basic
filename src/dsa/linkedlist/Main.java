package dsa.linkedlist;


public class Main {

    // Walk the chain: start at head, follow .next until null. O(n)
    static String format(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while (cur != null) {
            sb.append(cur.val).append(" -> "); 
            cur = cur.next;
        }
        return sb.append("null").toString();
    }

    // INSERT AT HEAD: O(1). New node points to the old head.
    static ListNode insertAtHead(ListNode head, int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        return node;                       // the new node IS the new head
    }

    // INSERT AT END (TAIL): O(n). Must walk to the last node first.
    static ListNode insertAtEnd(ListNode head, int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            return node;                   // empty list: new node is the head
        }
        ListNode cur = head;
        while (cur.next != null) {         // stop AT the last node, not past it
            cur = cur.next;
        }
        cur.next = node;
        return head;
    }

    // ACCESS BY INDEX: O(n). No jumping like arrays; you must walk.
    static int get(ListNode head, int index) {
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    // DELETE BY VALUE using DUMMY node: handles deleting the head
    // the same way as any other node. (Used in Remove Nth Node From End.)
    static ListNode deleteValue(ListNode head, int target) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == target) {
                cur.next = cur.next.next;  // SKIP over the target node
                break;
            }
            cur = cur.next;
        }
        return dummy.next;                 // real head (may have changed)
    }

    // REVERSE: the classic. Flip each arrow, one node at a time.
    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;      // 1. SAVE the rest of the list
            cur.next = prev;               // 2. FLIP the arrow backward
            prev = cur;                    // 3. move prev forward
            cur = next;                    // 4. move cur forward
        }
        return prev;                       // prev ends on the old tail = new head
    }

    public static void main(String[] args) {
        System.out.println("Node = null");
        ListNode head = null;

        System.out.println("We insert at end in this order: 1, 2, 3, 7, 8");
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 7);
        head = insertAtEnd(head, 8);
        System.out.println(format(head) + "\n");

        System.out.println("Insert at Head: 0");
        head = insertAtHead(head, 0);
        System.out.println(format(head) + "\n");

        System.out.println("Index at 4: " + get(head, 4) + "\n");

        System.out.println("Delete target 0: ");
        head = deleteValue(head, 0);       // delete the HEAD: dummy makes this easy
        System.out.println(format(head)+ "\n");

        System.out.println("Delete from middle target 3: ");
        head = deleteValue(head, 3);       // delete from the middle
        System.out.println(format(head)+ "\n");

        System.out.println("Add at the End: 5");
        head = insertAtEnd(head, 5);
        System.out.println("We now Reverse: ");
        head = reverse(head);
        System.out.println(format(head)+ "\n");
    }
}