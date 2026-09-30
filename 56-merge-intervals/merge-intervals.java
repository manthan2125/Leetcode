import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> res = new ArrayList<>();

        int s1 = intervals[0][0];
        int e1 = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int s2 = intervals[i][0];
            int e2 = intervals[i][1];

            if (e1 >= s2) {
                e1 = Math.max(e1, e2);
            } else {
                res.add(new int[]{s1, e1});
                s1 = s2;
                e1 = e2;
            }
        }
        res.add(new int[]{s1, e1});
        return res.toArray(new int[res.size()][]);
    }
}