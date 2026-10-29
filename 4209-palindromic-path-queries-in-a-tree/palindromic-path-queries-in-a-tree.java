
import java.util.*;

class Solution {
    int[] parent, depth, tin, tout, iter;
    int[][] up;
    List<Integer>[] adj;
    int timer;
    int LOG;
    int[] prefix;
    Fenwick bit;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        iter = new int[n];
        prefix = new int[n];

        LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        up = new int[LOG][n];

        int[] stack = new int[n];
        int top = 0;
        stack[0] = 0;

        parent[0] = 0;
        prefix[0] = 1 << (s.charAt(0) - 'a');
        tin[0] = timer++;

        while (top >= 0) {
            int u = stack[top];

            if (iter[u] < adj[u].size()) {
                int v = adj[u].get(iter[u]++);

                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                prefix[v] = prefix[u] ^ (1 << (s.charAt(v) - 'a'));
                tin[v] = timer++;

                stack[++top] = v;
            } else {
                tout[u] = timer - 1;
                top--;
            }
        }

        for (int i = 0; i < n; i++) {
            up[0][i] = parent[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        bit = new Fenwick(n + 1);
        char[] chars = s.toCharArray();
        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            int u = Integer.parseInt(parts[1]);

            if (parts[0].equals("update")) {
                char c = parts[2].charAt(0);

                if (chars[u] == c) {
                    continue;
                }

                int change = (1 << (chars[u] - 'a'))
                           ^ (1 << (c - 'a'));

                bit.rangeXor(tin[u], tout[u], change);
                chars[u] = c;
            } else {
                int v = Integer.parseInt(parts[2]);
                int l = lca(u, v);

                int mask = prefix[u] ^ bit.pointQuery(tin[u]);
                mask ^= prefix[v] ^ bit.pointQuery(tin[v]);
                mask ^= 1 << (chars[l] - 'a');

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return parent[u];
    }

    static class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int i, int val) {
            for (; i <= n; i += i & -i) {
                tree[i] ^= val;
            }
        }

        void rangeXor(int l, int r, int val) {
            update(l + 1, val);
            update(r + 2, val);
        }

        int pointQuery(int index) {
            int result = 0;

            for (int i = index + 1; i > 0; i -= i & -i) {
                result ^= tree[i];
            }

            return result;
        }
    }
}
