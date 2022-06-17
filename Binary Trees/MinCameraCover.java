// https://leetcode.com/problems/binary-tree-cameras/
// https://www.youtube.com/watch?v=uoFrIIrp5_g&ab_channel=Pepcoding
public class MinCameraCover {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.left = new TreeNode();
        root.left.left = new TreeNode();
        root.left.left.left = new TreeNode();
        root.left.left.left.right = new TreeNode();

        System.out.println(minCameraCover(root));
    }

    public static int cameras=0;
    public static int minCameraCover(TreeNode root) {
        cameras=0;
        if(solve(root)==-1) cameras++;
        return cameras;
    }
    // 1  :: Already Covered
    // 0  :: Has Camera
    // -1 :: Uncovered
    public static int solve(TreeNode root){
        if(root==null) return 1;
        
        int lc = solve(root.left);
        int rc = solve(root.right);
        
        if(lc==-1 || rc==-1){
            cameras++;
            return 0;
        }
        
        if(lc==0 || rc==0){
            return 1;
        }
        
        return -1;
        
    }
        
}
