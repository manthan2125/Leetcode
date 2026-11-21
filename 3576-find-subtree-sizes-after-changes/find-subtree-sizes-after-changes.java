
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] newParent = new int[n];
        int[] oldLast = new int[n];
        int[] order = new int[n];

        int[] stack = new int[2 * n];
        int top = 0;
        int idx = 0;

        stack[top++] = 0;

        while (top > 0) {
            int node = stack[--top];

            if (node < 0) {
                node = ~node;
                int c = s.charAt(node) - 'a';
                last[c] = oldLast[node];
                continue;
            }

            int c = s.charAt(node) - 'a';

            oldLast[node] = last[c];

            newParent[node] = (last[c] == -1)
                    ? parent[node]
                    : last[c];

            last[c] = node;

            order[idx++] = node;

            stack[top++] = ~node;

            for (int child : adj[node]) {
                stack[top++] = child;
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = n - 1; i >= 0; i--) {
            int node = order[i];

            if (newParent[node] != -1) {
                ans[newParent[node]] += ans[node];
            }
        }

        return ans;
    }
}
