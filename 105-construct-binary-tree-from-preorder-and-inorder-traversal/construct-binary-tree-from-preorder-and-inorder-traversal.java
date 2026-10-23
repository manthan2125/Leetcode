class Solution {
    static HashMap<Integer, Integer> in = new HashMap<>();
    static int idx = 0;
    TreeNode fun(int[] preorder, int low, int high){
        if(low > high) return null;
        TreeNode node = new TreeNode(preorder[idx]);
        idx++;
        int id = in.get(node.val);
        node.left = fun(preorder, low, id-1);
        node.right = fun(preorder, id+1, high);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = 0;
        in = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            in.put(inorder[i], i);
        }
        return fun(preorder, 0, inorder.length - 1);
    }
}