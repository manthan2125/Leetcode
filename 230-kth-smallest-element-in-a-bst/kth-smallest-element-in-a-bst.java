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
    static Stack<TreeNode> asc = new Stack<>();
    TreeNode getSmall(){
        if(asc.size() == 0) return null;
        TreeNode small = asc.pop();
        TreeNode rightChild = small.right;
        while(rightChild != null){
            asc.push(rightChild);
            rightChild = rightChild.left;
        }
        return small;
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        TreeNode t = root;
        while(t != null){
            asc.push(t);
            t = t.left;
        }
        TreeNode kthSmall = null;
        for(int i = 0; i < k; i++){
            kthSmall = getSmall();
        }
        return kthSmall.val;
    }
}