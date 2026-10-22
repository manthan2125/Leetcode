/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // public boolean hasPathSum(TreeNode root, int targetSum) {
    //     if(root == null) return false;
    //     if(root.left == null && root.right == null) {
    //         if(targetSum == root.val) return true;
    //         else return false;
    //     }
    //     return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    // }

    boolean res = false;
    public void fun(TreeNode root, int sum, int targetSum){
        if(root == null) return;
        sum += root.val;
        if(root.left == null && root.right == null){
            if(sum == targetSum) res = true;
            return; 
        }
        fun(root.left, sum ,targetSum);
        fun(root.right, sum ,targetSum);
        return;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        fun(root, 0, targetSum);
        return res;
        
    }
}