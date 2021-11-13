// my solution
// https://practice.geeksforgeeks.org/problems/count-number-of-subtrees-having-given-sum/1

/*
 * class Node { int data; Node left,right; Node(int d) { data=d;
 * left=right=null; } }
 */

// class Tree
// {
// public static int ans = 0;
// //Function to count number of subtrees having sum equal to given sum.
// int countSubtreesWithSumX(Node root, int X)
// {
// ans = 0;
// if(root == null)
// {
// return ans;
// }

// sum(root, X);
// return ans;
// }

// public int sum(Node root, int x){
// if(root==null){
// return 0;
// }
// int lsum = 0;
// int rsum = 0;

// if(root.left!=null){
// lsum = sum(root.left, x);
// }

// if(root.right!=null){
// rsum = sum(root.right, x);
// }

// int totalSum = lsum+rsum + root.data;

// if(totalSum == x){
// ans++;
// }
// return totalSum;
// }

// }