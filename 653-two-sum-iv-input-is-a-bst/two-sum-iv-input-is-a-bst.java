class Solution {
    static Stack<TreeNode> asc = new Stack<>();
    static Stack<TreeNode> desc = new Stack<>();
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
    TreeNode getBig(){
        if(desc.size() == 0) return null;
        TreeNode big = desc.pop();
        TreeNode leftChild = big.left;
        while(leftChild != null){
            desc.push(leftChild);
            leftChild = leftChild.right;
        }
        return big;
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        TreeNode t = root;
        while(t != null){
            asc.push(t);
            t = t.left;
        }
        t = root;
        while(t != null){
            desc.push(t);
            t = t.right;
        }
        TreeNode i = getSmall();
        TreeNode j = getBig();
        while(i != null && j != null && i != j && i.val <= j.val){
            int sum = i.val + j.val;
            if(sum == k) return true;
            if(sum > k) j = getBig();
            else i = getSmall();
        }
        return false;
    }
}