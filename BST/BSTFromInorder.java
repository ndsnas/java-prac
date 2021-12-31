
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/construct-bst-from-inorder-traversal/ojquestion
// https://www.youtube.com/watch?v=UAsLKuEMhsQ&t=188s&ab_channel=Pepcoding
import java.util.Scanner;

public class BSTFromInorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructFromInOrder(int[] inOrder) {
        return createTree(inOrder, 0, inOrder.length - 1);
    }

    public static TreeNode createTree(int[] inOrder, int si, int ei) {
        if (ei < si) {
            return null;
        }

        int mid = (ei + si) / 2;

        TreeNode node = new TreeNode(inOrder[mid]);
        // left of mid will be left subtree
        node.left = createTree(inOrder, si, mid - 1);
        // right of mid will be right subtree
        node.right = createTree(inOrder, mid + 1, ei);

        return node;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = constructFromInOrder(in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}

// INPUT
// 7
// 1 2 3 4 5 6 7

// OUTPUT

// 2 -> 4 <- 6
// 1 -> 2 <- 3
// . -> 1 <- .
// . -> 3 <- .
// 5 -> 6 <- 7
// . -> 5 <- .
// . -> 7 <- .