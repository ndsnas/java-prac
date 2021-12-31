
import java.util.Scanner;

public class BSTFromPostorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int index = 0;

    public static TreeNode bstFromPostorder(int[] postorder) {
        index = postorder.length - 1;
        return createTree(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public static TreeNode createTree(int[] postorder, int lr, int rr) {
        if (index < 0 || postorder[index] < lr || postorder[index] > rr) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[index--]);

        node.right = createTree(postorder, node.val, rr);
        node.left = createTree(postorder, lr, node.val);
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}

// INPUT

// 6
// 1 2 6 7 5 3

// OUTPUT

// 2 -> 3 <- 5
// 1 -> 2 <- .
// . -> 1 <- .
// . -> 5 <- 7
// 6 -> 7 <- .
// . -> 6 <- .
