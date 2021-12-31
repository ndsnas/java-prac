
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/construct-bst-from-levelorder-traversal/ojquestion
// https://www.youtube.com/watch?v=8w_NSKo9e74&ab_channel=Pepcoding
import java.util.*;

public class BSTFromLevelOrder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Pair {
        TreeNode node;
        int lr = Integer.MIN_VALUE;
        int rr = Integer.MAX_VALUE;

        Pair(TreeNode node, int lr, int rr) {
            this.node = node;
            this.lr = lr;
            this.rr = rr;
        }

        Pair() {
        }
    }

    // in this we're using queue to store 2 Pair objects per node:
    // 1. Node and its left range ex: -INFINITY to node.val
    // 2. Node and its right range ex: node.val to INFINITY
    // After that we're dequeueing elements from queue in checking if the current
    // element in the array false in the range of the Pair or not
    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
        TreeNode root = null;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair());

        int index = 0;
        while (q.peek() != null && index < LevelOrder.length) {
            Pair pair = q.remove();
            int ele = LevelOrder[index];
            if (ele < pair.lr || ele > pair.rr) {
                continue;
            }
            index++;
            TreeNode node = new TreeNode(ele);
            if (pair.node == null) {
                root = node;
            } else {
                if (ele <= pair.node.val) {
                    pair.node.left = node;
                } else {
                    pair.node.right = node;
                }
            }
            q.add(new Pair(node, pair.lr, ele));
            q.add(new Pair(node, ele, pair.rr));

        }

        return root;
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
        int[] level = new int[n];
        for (int i = 0; i < n; i++)
            level[i] = scn.nextInt();

        TreeNode root = constructBSTFromLevelOrder(level);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}

// INPUT
// 6
// 3 2 5 1 6 7

// OUTPUT
// 2 -> 3 <- 5
// 1 -> 2 <- .
// . -> 1 <- .
// . -> 5 <- 6
// . -> 6 <- 7
// . -> 7 <- .