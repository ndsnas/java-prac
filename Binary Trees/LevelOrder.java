
// https://leetcode.com/problems/binary-tree-level-order-traversal/
import java.util.*;

public class LevelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;

        Queue<TreeNode> q = new LinkedList<>();
        int current_level_count = 0;
        int next_level_count = 0;
        q.add(root);
        current_level_count++;

        while (!q.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            while (current_level_count != 0) {
                current_level_count--;
                TreeNode node = q.remove();
                temp.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                    next_level_count++;
                }
                if (node.right != null) {
                    q.add(node.right);
                    next_level_count++;
                }
            }
            list.add(temp);
            current_level_count = next_level_count;
            next_level_count = 0;
        }

        return list;

    }
}
