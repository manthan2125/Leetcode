class Solution {
    static TreeNode ans = null;
    public int fun(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return 0;
        int left =  fun(root.left, p, q);
        int right = fun(root.right, p, q);   
        int self = 0;
        if(root == p || root == q) self = 1;
        int total = self + left + right;
        if(total == 2 && ans == null) ans = root;
        return total;   
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        fun(root, p, q);
        return ans;
    }
}