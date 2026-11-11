package dsa.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class Main {

    // ================= BST INSERT (recursive) =================
    // BST rule: smaller values go LEFT, larger go RIGHT.
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);                 // found the empty spot
        }

        if (val < root.val) {
            root.left = insert(root.left, val);       // ASSIGN the result back

        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }                                             // equal: ignore duplicates
        return root;
    }

    // ================= BST SEARCH (iterative, prints the path) =================
    public static boolean search(TreeNode root, int target) {
        StringBuilder path = new StringBuilder();
        TreeNode cur = root;
        while (cur != null) {
            path.append(cur.val);
            if (cur.val == target) {
                 System.out.println("Search " + target + ": " + path + " found");
                return true;
            }
            path.append(" -> ");
            cur = (target < cur.val) ? cur.left : cur.right;   // go left or right
        }
        System.out.println("Search " + target + ": " + path + "not found");
        return false;
    }

    // ================= THE THREE DFS TRAVERSALS =================
    // Compare them: the ONLY difference is where out.add(...) sits.

    public static void preorder(TreeNode node, List<Integer> out) {     // node, left, right
        if (node == null) return;
        out.add(node.val);              // NODE first
        preorder(node.left, out);
        preorder(node.right, out);
    }

    public static void inorder(TreeNode node, List<Integer> out) {     // left, node , right
        if (node == null) return;
        inorder(node.left, out);
        out.add(node.val);              // NODE in the middle
        inorder(node.right, out);
    }

    public static void postorder(TreeNode node, List<Integer> out) {   // left, right, node
        if (node == null) return;
        postorder(node.left, out);
        postorder(node.right, out);
        out.add(node.val);              // NODE last
    }

    // ================= PREORDER WITHOUT RECURSION =================
    // Recursion uses the call stack; here we use our stack.
    // This is why DFS and stacks go together.
    public static List<Integer> preorderIterative(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null) return out;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            out.add(node.val);
            if (node.right != null) stack.push(node.right);   // push RIGHT first.
            if (node.left != null) stack.push(node.left);     // .so LEFT is popped first
        }
        return out;
    }

    // ================= SEE THE DEPTH-FIRST PATH =================
    public static void tracePreorder(TreeNode node, int depth) {
        if (node == null) return;
        System.out.println("  ".repeat(depth) + "visit " + node.val);
        tracePreorder(node.left, depth + 1);
        tracePreorder(node.right, depth + 1);
    }


    // ================= BFS: LEVEL ORDER =================
    // Queue = first in, first out → nodes come out in the order they were found,
    // which is level by level.
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null) return out;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();                   // earliest discovered
            out.add(node.val);
            if (node.left != null) queue.offer(node.left);  // LEFT first,
            if (node.right != null) queue.offer(node.right); // so it comes out first
        }
        return out;
    }

    // ================= SEE THE QUEUE AT EACH STEP =================
    public static void traceLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            System.out.println("poll " + node.val + " -> queue " + values(queue));
        }
    }

    // Helper: the queue holds TreeNodes, so pull out their values for printing.
    private static List<Integer> values(Queue<TreeNode> queue) {
        List<Integer> out = new ArrayList<>();
        for (TreeNode n : queue) out.add(n.val);
        return out;
    }

    // ================= LEVEL ORDER, GROUPED BY LEVEL =================
    // The trick: before each level, record queue.size(). Exactly that many nodes
    // belong to the current level; anything offered during the loop is the NEXT level.
    public static List<List<Integer>> levelOrderGrouped(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();                   // FREEZE this level's count
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            levels.add(level);
        }
        return levels;
    }

    // ================= MAX DEPTH =================
    // Depth = 1 (this node) + the deeper of the two subtrees.
    public static int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    public static int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // MIN = keep going left; MAX = keep going right.
    public static int min(TreeNode root) {
        TreeNode cur = root;
        while (cur.left != null) cur = cur.left;
        return cur.val;
    }

    public static int max(TreeNode root) {
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        return cur.val;
    }

    // ================= VALIDATE BST =================
    // WRONG way: only compares each node with its direct children.
    // RIGHT way: every node must fit within bounds set by ALL its ancestors.
    public static boolean isValidBST(TreeNode node, long low, long high) {
        if (node == null) return true;
        if (node.val <= low || node.val >= high) return false;
        return isValidBST(node.left, low, node.val)       // left: must be < node
            && isValidBST(node.right, node.val, high);    // right: must be > node
    }

    // Prints the tree sideways: root on the left, right subtree on top.
    public static void printSideways(TreeNode node, int depth) {
        if (node == null) return;
        printSideways(node.right, depth + 1);
        System.out.println("    ".repeat(depth) + node.val);
        printSideways(node.left, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode root = null;

        System.out.println("Insert into tree: 50, 30, 70, 20, 40, 60, 80, 35 \n");
        int[] values = {50, 30, 70, 20, 40, 60, 80, 35};
        for (int v : values) {
            root = insert(root, v);
        }

        System.out.println("Tree (sideways, root on the left):");
        printSideways(root, 0);

        System.out.println();
        search(root, 35);
        search(root, 65);

        System.out.println();
        System.out.println("Max depth: " + maxDepth(root));
        System.out.println("Node count: " + countNodes(root));
        System.out.println("Min: " + min(root));
        System.out.println("Max: " + max(root));
        System.out.println("Valid BST:  " + isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE) + "\n");

        // A tree that LOOKS fine locally but breaks the BST rule:
        //       5
        //      / \
        //     3   8
        //      \
        //       6      ← 6 > 5, but it's in 5's LEFT subtree    
        TreeNode bad = new TreeNode(5);
        bad.left = new TreeNode(3);
        bad.right = new TreeNode(8);
        bad.left.right = new TreeNode(6);
        
        System.out.println("Bad tree example:");
        System.out.println("Bad tree (built by hand, NOT with insert):");
        System.out.println("root 5, root.left 3, root.right 8, root.left.right 6");
        printSideways(bad, 0);

        System.out.println("Bad tree correct check: " + isValidBST(bad, Long.MIN_VALUE, Long.MAX_VALUE) + "\n");


        TreeNode good = null; 
        for(int v : new int []{100, 45, 165, 35, 170, 120, 55, 10}) { 
            good = insert(good, v); 
        }
        System.out.println("Three DFS traversals");
        System.out.println("We insert on the tree: 100, 45, 165, 35, 170, 120, 55, 10");
        printSideways(good, 0);

        List<Integer> pre = new ArrayList<>(); 
        preorder(good, pre);
        System.out.println("Preorder: " + pre);

        List<Integer> in = new ArrayList<>();
        inorder(good, in);
        System.out.println("Inorder:   " + in);

        List<Integer> post = new ArrayList<>();
        postorder(good, post);
        System.out.println("Postorder: " + post);

        System.out.println("Iterative preorder: " + preorderIterative(good));

        System.out.println("Preorder trace:");
        tracePreorder(good, 0);

        System.out.println();
        System.out.println("root = [50, 30, 70, 20, 40, 60, 80, 35]");
        System.out.println("BFS level order: " + levelOrder(root));
        System.out.println("BFS trace:");
        traceLevelOrder(root);
        System.out.println("Levels: " + levelOrderGrouped(root));
        
    }
}