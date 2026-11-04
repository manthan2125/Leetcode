
import java.util.*;

class Solution {
    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();

    long lowSum = 0, highSum = 0;
    int lowSize = 0, highSize = 0;
    int target;

    void add(int val) {
        if (low.isEmpty() || val <= low.lastKey()) {
            low.merge(val, 1, Integer::sum);
            lowSum += val;
            lowSize++;
        } else {
            high.merge(val, 1, Integer::sum);
            highSum += val;
            highSize++;
        }
    }

    void remove(TreeMap<Integer, Integer> map, int val) {
        int c = map.get(val);

        if (c == 1) map.remove(val);
        else map.put(val, c - 1);
    }

    void erase(int val) {
        if (low.containsKey(val)) {
            remove(low, val);
            lowSum -= val;
            lowSize--;
        } else {
            remove(high, val);
            highSum -= val;
            highSize--;
        }
    }

    void balance() {
    while (lowSize > target) {
        int v = low.lastKey();

        remove(low, v);
        lowSum -= v;
        lowSize--;

        high.merge(v, 1, Integer::sum);
        highSum += v;
        highSize++;
    }

    while (lowSize < target) {
        int v = high.firstKey();

        remove(high, v);
        highSum -= v;
        highSize--;

        low.merge(v, 1, Integer::sum);
        lowSum += v;
        lowSize++;
    }

    while (!low.isEmpty() && !high.isEmpty()
            && low.lastKey() > high.firstKey()) {

        int a = low.lastKey();
        int b = high.firstKey();

        remove(low, a);
        remove(high, b);

        low.merge(b, 1, Integer::sum);
        high.merge(a, 1, Integer::sum);

        lowSum += (long) b - a;
        highSum += (long) a - b;
    }
}

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        low.clear();
        high.clear();

        lowSum = 0;
        highSum = 0;
        lowSize = 0;
        highSize = 0;

        target = (x + 1) / 2;

        long[] cost = new long[n - x + 1];

        for (int i = 0; i < x; i++) {
            low.merge(nums[i], 1, Integer::sum);
            lowSum += nums[i];
            lowSize++;
        }

        balance();

        for (int i = 0; i <= n - x; i++) {
            long median = low.lastKey();

            cost[i] = median * lowSize - lowSum
                    + highSum - median * highSize;

            if (i == n - x) break;

            erase(nums[i]);
            add(nums[i + x]);
            balance();
        }

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }

        Arrays.fill(dp[0], 0);

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];

                if (i >= x && dp[j - 1][i - x] != INF) {
                    dp[j][i] = Math.min(
                        dp[j][i],
                        dp[j - 1][i - x] + cost[i - x]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
