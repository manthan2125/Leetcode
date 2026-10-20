class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0){
            int levelSize = q.size();   
            List<Integer> temp = new ArrayList<>(levelSize);
            while(levelSize-- > 0){
                TreeNode front = q.remove();
                temp.add(front.val);
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
            res.add(temp);
        }
        return res;
    }
}