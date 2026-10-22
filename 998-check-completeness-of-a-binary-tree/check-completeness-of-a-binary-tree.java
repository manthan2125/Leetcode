
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return false;
        boolean nullFound = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0){
            TreeNode t = q.remove();
            if(t == null) nullFound = true;
            else{
                if(nullFound) return false;
                q.add(t.left);
                q.add(t.right);
            }
        }
        return true;
    }
}