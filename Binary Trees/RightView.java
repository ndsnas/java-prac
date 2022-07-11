
// https://leetcode.com/problems/binary-tree-right-side-view/
// https://www.youtube.com/watch?v=WmjXEfF6Iy4&ab_channel=ProgrammingLivewithLarry
import java.util.*;

public class RightView {

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

        System.out.println(solution1(root));

        List<Integer> ans = new ArrayList<>();

        solution2(root, 1, ans);

        System.out.println(ans);

    }

    public static List<Integer> solution1(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();

        int curr_level_count = 0;
        int next_level_count = 0;

        q.add(root);
        curr_level_count++;

        while (!q.isEmpty()) {
            TreeNode ele = q.remove();
            curr_level_count--;

            if (ele.left != null) {
                q.add(ele.left);
                next_level_count++;
            }

            if (ele.right != null) {
                q.add(ele.right);
                next_level_count++;
            }

            if (curr_level_count == 0) {
                list.add(ele.val);
                curr_level_count = next_level_count;
                next_level_count = 0;
            }
        }
        return list;
    }

    public static void solution2(TreeNode root, int level, List<Integer> ans) {
        if (root == null)
            return;

        // At each recurrence, level is increasing so the ans length should also
        // increase.
        // If ans lenght is less than level that means first
        // element of that level should be added.
        // First element is added because every time we're going first to the right
        // child.
        if (ans.size() < level)
            ans.add(root.val);

        solution2(root.right, level + 1, ans);
        solution2(root.left, level + 1, ans);

    }
}
