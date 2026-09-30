class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // ArrayList<int[]> res = new ArrayList<>();
        // for(int[] interval : intervals){
        //     res.add(interval);
        // }
        // res.add(newInterval);

        // res.sort((a,b) -> Integer.compare(a[0], b[0]));

        int n = intervals.length;
        int len = n + 1;
        int[][] newIntervals = new int[len][];
        for(int i = 0; i < n; i++){
            newIntervals[i] = intervals[i];
        }
        newIntervals[len - 1] = newInterval;
        Arrays.sort(newIntervals, (a,b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> res = new ArrayList<>();
        int s1 = newIntervals[0][0];
        int e1 = newIntervals[0][1];
        for (int i = 1; i < newIntervals.length; i++) {

            int s2 = newIntervals[i][0];
            int e2 = newIntervals[i][1];

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