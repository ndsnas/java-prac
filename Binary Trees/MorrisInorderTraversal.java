public class MorrisInorderTraversal {

    public static class Node {
        int data;
        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);
        root.right = new Node(7);
        root.right.right = new Node(9);
        root.right.right.left = new Node(8);
        traversal(root);
    }

    public static void traversal(Node root) {
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                Node left = curr.left;
                Node rightMostNodeOfLeftNode = getRightMostNode(left, curr);

                if (rightMostNodeOfLeftNode.right != curr) {
                    // create thread & move to left
                    rightMostNodeOfLeftNode.right = curr;
                    curr = curr.left;
                } else {
                    // destroy thread & print & print to right
                    rightMostNodeOfLeftNode.right = null;
                    System.out.println(curr.data);
                    curr = curr.right;
                }
            } else {
                // when curr.left==null then print the current node & move to right
                System.out.println(curr.data);
                curr = curr.right;
            }
        }

    }

    private static Node getRightMostNode(Node left, Node curr) {
        while (left.right != null && left.right != curr) {
            left = left.right;
        }
        return left;
    }
}
