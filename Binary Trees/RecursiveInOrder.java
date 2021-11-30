import java.util.Stack;

public class RecursiveInOrder {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        inOrder(root);
    }

    public static class Node {
        int val;
        Node left = null;
        Node right = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static void inOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || stack.empty() == false) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            Node node = stack.pop();
            System.out.print(node.val + ", ");
            root = node.right;
        }
    }
}
