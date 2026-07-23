package DSA_Basics.gcr_codebase.Binary_search_tree;

public class LCABST {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node lowestCommonAncestor(Node root, int p, int q) {

        Node curr = root;

        while (curr != null) {

            if (p < curr.val && q < curr.val)
                curr = curr.left;

            else if (p > curr.val && q > curr.val)
                curr = curr.right;

            else
                return curr;
        }

        return null;
    }

    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);

        Node ans = lowestCommonAncestor(root, 20, 40);

        System.out.println(ans.val);
    }
}   