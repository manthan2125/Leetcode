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
    static int res = 0;
    int fun(TreeNode root){
        if(root == null) return 0;
        int left = fun(root.left);
        int right = fun(root.right);
        int sum = left + right;
        res = Math.max(res,sum);
        return 1+ Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        fun(root);
        return res;
    }
}