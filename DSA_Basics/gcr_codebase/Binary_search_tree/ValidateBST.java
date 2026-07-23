package DSA_Basics.gcr_codebase.Binary_search_tree;

public class ValidateBST {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validate(Node root, long min, long max) {

        if (root == null)
            return true;

        if (root.val <= min || root.val >= max)
            return false;

        return validate(root.left, min, root.val)
                && validate(root.right, root.val, max);
    }

    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);

        System.out.println(isValidBST(root));
    }
}
