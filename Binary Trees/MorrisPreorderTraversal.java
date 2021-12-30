// https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
// https://www.youtube.com/watch?v=viegWtuH0uI
// https://www.youtube.com/watch?v=8rwHi5CXwqY&t=2536s

/* only difference between morris in-order and pre-order traversal is that 
in in-order traversal we print when the left subtree is completely processed or left subtree is null
while in pre-order traversal we print when we arrive on a new node or when the left subtree is null
*/
public class MorrisPreorderTraversal {

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

                if (rightMostNodeOfLeftNode.right == null) {
                    // rightMostNodeOfLeftNode.right is null means no thread is present
                    // create thread & move to left
                    rightMostNodeOfLeftNode.right = curr;
                    // since we arrived on a new node we need to print it as per pre-order traversal
                    System.out.println(curr.data);
                    curr = curr.left;
                } else {
                    // rightMostNodeOfLeftNode.right is not null means already thread is present
                    // otherwise rightmost child would have be null
                    // destroy thread
                    rightMostNodeOfLeftNode.right = null;
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
