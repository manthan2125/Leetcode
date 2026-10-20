class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int leftToRight = 1;
        q.add(root);
        while(q.size() > 0){
            int levelSize = q.size();
            int[] temp = new int[levelSize];
            int first = 0;
            int last = levelSize - 1;
            while(levelSize-- > 0){
                TreeNode front = q.remove();
                if(leftToRight ==  1) temp[first++] = front.val;
                else temp[last--] = front.val;
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
            List<Integer> ans = new ArrayList<>();
            for(int ele : temp) ans.add(ele);
            res.add(ans);
            leftToRight = 1 - leftToRight;
        }
        return res;
    }
}