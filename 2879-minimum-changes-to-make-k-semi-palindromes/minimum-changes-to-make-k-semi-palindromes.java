
class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;
                cost[l][r] = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int changes = 0;
                    int groups = len / d;

                    for (int x = 0; x < d; x++) {
                        for (int t = 0; t < groups / 2; t++) {
                            int left = l + x + t * d;
                            int right = l + x + (groups - 1 - t) * d;

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                        }
                    }

                    cost[l][r] = Math.min(cost[l][r], changes);
                }
            }
        }

        int INF = 1000000;
        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            java.util.Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {
            for (int i = 2 * p; i <= n; i++) {
                for (int j = 2 * (p - 1); j <= i - 2; j++) {
                    dp[p][i] = Math.min(
                        dp[p][i],
                        dp[p - 1][j] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
