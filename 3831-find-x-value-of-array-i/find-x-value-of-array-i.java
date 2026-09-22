class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int mod = num % k;

            long[] next = new long[k];

            // Start a new subarray with only nums[i]
            next[mod] = 1;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {
                int newR = (int) ((long) r * mod % k);
                next[newR] += dp[r];
            }

            // Add current subarrays to the final answer
            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }

            dp = next;
        }

        return result;
    }
}