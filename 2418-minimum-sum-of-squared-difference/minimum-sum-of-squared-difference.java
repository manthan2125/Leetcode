class Solution {
public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
long[] freq = new long[100001];
long operations = (long) k1 + k2;
long max = 0;

    for (int i = 0; i < nums1.length; i++) {
        long diff = Math.abs(nums1[i] - nums2[i]);
        freq[(int) diff]++;
        max = Math.max(max, diff);
    }

    if (operations == 0) {
        long sum = 0;
        for (int i = 0; i < freq.length; i++) {
            sum += freq[i] * i * i;
        }
        return sum;
    }

    while (operations > 0 && max > 0) {
        long count = freq[(int) max];
        long move = Math.min(operations, count);

        freq[(int) max] -= move;
        freq[(int) max - 1] += move;

        operations -= move;
        max--;
    }

    long result = 0;

    for (int i = 0; i < freq.length; i++) {
        result += freq[i] * i * i;
    }

    return result;
}


}
