class Solution {
    public TreeNode searchBST(TreeNode root, int k) {
        if(root == null) return null;
        if(root.val == k) return root;
        if(root.val > k) return searchBST(root.left, k);
        return searchBST(root.right, k);

    }
}