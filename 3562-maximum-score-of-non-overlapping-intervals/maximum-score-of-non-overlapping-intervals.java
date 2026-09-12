import java.util.*;

class Solution {
    static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = findPrevious(arr, i);
        }

        State[][] dp = new State[n + 1][5];

        for (int k = 0; k <= 4; k++) {
            dp[0][k] = new State(k == 0 ? 0 : Long.MIN_VALUE, new int[0]);
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0] = new State(0, new int[0]);

            for (int k = 1; k <= 4; k++) {
                State skip = dp[i - 1][k];

                State take = null;

                int p = prev[i - 1];

                if (dp[p + 1][k - 1].score != Long.MIN_VALUE) {
                    int[] old = dp[p + 1][k - 1].indices;
                    int[] newIndices = Arrays.copyOf(old, old.length + 1);

                    newIndices[newIndices.length - 1] = arr[i - 1][3];
                    Arrays.sort(newIndices);

                    take = new State(
                        dp[p + 1][k - 1].score + arr[i - 1][2],
                        newIndices
                    );
                }

                dp[i][k] = better(skip, take);
            }
        }

        State answer = dp[n][0];

        for (int k = 1; k <= 4; k++) {
            answer = better(answer, dp[n][k]);
        }

        return answer.indices;
    }

    private State better(State a, State b) {
        if (b == null) {
            return a;
        }

        if (a.score > b.score) {
            return a;
        }

        if (b.score > a.score) {
            return b;
        }

        return lexicographicallySmaller(a.indices, b.indices) ? a : b;
    }

    private boolean lexicographicallySmaller(int[] a, int[] b) {
        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }

        return a.length < b.length;
    }

    private int findPrevious(int[][] arr, int index) {
        int left = 0;
        int right = index - 1;
        int target = arr[index][0];
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid][1] < target) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}