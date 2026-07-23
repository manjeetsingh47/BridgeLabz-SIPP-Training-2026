package DSA_Basics.gcr_codebase.Binary_search_tree;

import java.util.*;

public class KthSmallestBST {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static int kthSmallest(Node root, int k) {

        Stack<Node> stack = new Stack<>();
        Node curr = root;
        int count = 0;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            count++;

            if (count == k)
                return curr.val;

            curr = curr.right;
        }

        return -1;
    }

    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);

        System.out.println(kthSmallest(root, 3));
    }
}