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

    public void fun(TreeNode root, int sum, List<Integer> diary, List<List<Integer>> res, int targetSum){
        if(root == null) return;
        sum += root.val;
        diary.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                res.add(new ArrayList<>(diary));
                // diary.remove(root.val);
                diary.remove(diary.size() - 1);
                return;
            }
        }
        fun(root.left, sum, diary, res, targetSum);
        fun(root.right, sum, diary, res, targetSum);
        // diary.remove(root.val);
        diary.remove(diary.size() - 1);
        return;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();
        fun(root, 0, diary, res, targetSum);
        return res;
    }
}