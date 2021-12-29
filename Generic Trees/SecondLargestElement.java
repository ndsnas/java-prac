import java.util.*;
public class SecondLargestElement {

    public static class Node {
        int data;
        ArrayList<Node> children;

        Node(int data, ArrayList<Node> children) {
            this.data = data;
            this.children = children;
        }
    }

    public static void main(String[] args) {
        /* Create the following tree
                   1
                /  |  \
               2   3   4
             / | \
            5  6  7
        */
        ArrayList<Node> b = new ArrayList<>();
        b.add(new Node(5, null));
        b.add(new Node(6, null));
        b.add(new Node(7, null));
        ArrayList<Node> a = new ArrayList<>();
        a.add(new Node(2, b));
        a.add(new Node(3, null));
        a.add(new Node(4, null));
        Node root = new Node(1, a);
        secondLargestElement(root);
        System.out.println("largest number is :: " + largest.data);
        System.out.println("second largest number is :: " + secondLargest.data);

    }

    public static Node largest, secondLargest = null;

    public static void secondLargestElement(Node root) {
        
        if (root == null) {
            return;
        }

        if(largest != null && secondLargest != null){
            if (root.data > largest.data) {
                secondLargest.data = largest.data;
                largest.data = root.data;
            }
            else if (largest.data > root.data && secondLargest.data < root.data) {
                secondLargest.data = root.data;
            }
        } else {
            if (largest == null) {
                largest = root;
            } else {
                secondLargest = root;
                if (secondLargest.data > largest.data) {
                    int temp = largest.data;
                    largest.data = secondLargest.data;
                    secondLargest.data = temp;
                }
            }

            
        }
        
        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                secondLargestElement(root.children.get(i));
            }
        }
    }
}
