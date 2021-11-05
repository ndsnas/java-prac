import java.util.Scanner;

public class BSTFromPreorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // ===================== my code starts
    // ======================================================
    private static int index = 0;

    public static TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return createTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public static TreeNode createTree(int[] preorder, int lr, int rr) {
        if (index > preorder.length - 1 || preorder[index] < lr || preorder[index] > rr) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index++]);
        node.left = createTree(preorder, lr, node.val);
        node.right = createTree(preorder, node.val, rr);
        return node;
    }

    // ============== my code ends
    // ======================================================
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

        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}

// input
// 6 -- arraySize
// 8
// 5
// 1
// 7
// 10
// 12