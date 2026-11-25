
import java.util.*;

class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int m = n + 1;

        int[] a = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i];
        }

        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }

        int[] p = new int[m];
        int[] c = new int[m];

        int[] cnt = new int[Math.max(m, maxVal + 1)];

        for (int x : a) cnt[x]++;

        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
        }

        for (int i = m - 1; i >= 0; i--) {
            p[--cnt[a[i]]] = i;
        }

        c[p[0]] = 0;
        int classes = 1;

        for (int i = 1; i < m; i++) {
            if (a[p[i]] != a[p[i - 1]]) {
                classes++;
            }
            c[p[i]] = classes - 1;
        }

        int[] pn = new int[m];
        int[] cn = new int[m];

        for (int len = 1; len < m; len *= 2) {
            for (int i = 0; i < m; i++) {
                pn[i] = p[i] - len;
                if (pn[i] < 0) pn[i] += m;
            }

            Arrays.fill(cnt, 0, classes, 0);

            for (int i = 0; i < m; i++) {
                cnt[c[pn[i]]]++;
            }

            for (int i = 1; i < classes; i++) {
                cnt[i] += cnt[i - 1];
            }

            for (int i = m - 1; i >= 0; i--) {
                int x = pn[i];
                p[--cnt[c[x]]] = x;
            }

            cn[p[0]] = 0;
            int newClasses = 1;

            for (int i = 1; i < m; i++) {
                int cur = p[i];
                int prev = p[i - 1];

                int mid = (cur + len) % m;
                int midPrev = (prev + len) % m;

                if (c[cur] != c[prev] ||
                    c[mid] != c[midPrev]) {
                    newClasses++;
                }

                cn[cur] = newClasses - 1;
            }

            int[] temp = c;
            c = cn;
            cn = temp;

            classes = newClasses;

            if (classes == m) break;
            if (len > m / 2) break;
        }

        int[] sa = new int[n];

        for (int i = 1; i < m; i++) {
            sa[i - 1] = p[i];
        }

        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }

        int[] lcp = new int[n];
        int k = 0;

        for (int i = 0; i < n; i++) {
            int r = rank[i];

            if (r == 0) continue;

            int j = sa[r - 1];

            while (i + k < n && j + k < n &&
                   nums[i + k] == nums[j + k]) {
                k++;
            }

            lcp[r] = k;

            if (k > 0) k--;
        }

        int ans = n;

        for (int i = 0; i < n; i++) {
            int maxLcp = lcp[i];

            if (i + 1 < n) {
                maxLcp = Math.max(maxLcp, lcp[i + 1]);
            }

            int uniqueLength = maxLcp + 1;
            int suffixLength = n - sa[i];

            if (uniqueLength <= suffixLength) {
                ans = Math.min(ans, uniqueLength);
            }
        }

        return ans;
    }
}
