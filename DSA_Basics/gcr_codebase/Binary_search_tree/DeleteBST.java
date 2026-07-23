package DSA_Basics.gcr_codebase.Binary_search_tree;

public class DeleteBST {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node delete(Node root, int key) {

        if (root == null)
            return null;

        if (key < root.val)
            root.left = delete(root.left, key);

        else if (key > root.val)
            root.right = delete(root.right, key);

        else {

            if (root.left == null && root.right == null)
                return null;

            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            Node successor = root.right;

            while (successor.left != null)
                successor = successor.left;

            root.val = successor.val;

            root.right = delete(root.right, successor.val);
        }

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

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        root = delete(root, 50);

        inorder(root);
    }
}