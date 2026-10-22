class Solution {
    static TreeNode prev = null;
    boolean ans = true;
    public void fun(TreeNode root) {
        if(root == null) return;
        fun(root.left);
        if(prev == null) prev = root;
        else{
            if(root.val <= prev.val) ans = false;
            prev = root;
        }
        fun(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        ans = true;
        prev = null;
        fun(root);
        return ans;
    }
}