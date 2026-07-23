package DSA_Basics.gcr_codebase.Binary_search_tree;

public class InsertBST {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null)
            return new Node(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val);

        return root;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Node root = null;

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 40);

        inorder(root);
    }
}