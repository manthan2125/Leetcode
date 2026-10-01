class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        int n = a.length;
        int m = b.length;
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while(i < n && j < m){
            int st1 = a[i][0];
            int end1 = a[i][1];
            int st2 = b[j][0];
            int end2 = b[j][1];
            if( st1 <= st2){
                if( end1 >= st2 ){
                    int s = Math.max(st1, st2);
                    int e = Math.min(end1, end2);
                    res.add(new int[]{s,e});
                }
            }
            else{ // st2 <= st1
                if(end2 >= st1){
                    int s = Math.max(st1, st2);
                    int e = Math.min(end1, end2);
                    res.add(new int[]{s,e});
                }
            }
            if(end1 <= end2) i++;
            else j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}