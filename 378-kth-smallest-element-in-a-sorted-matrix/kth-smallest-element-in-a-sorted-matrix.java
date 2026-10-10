class Solution {
    public int  fun(int[][] mat, int n, int m, int guess){
        int row = n-1, col = 0, count = 0;
        while( row >= 0 && col < m){
            if(mat[row][col] <= guess){
                count += (row+1);
                col++;
            }
            else row--;
        }
        return count;
    }
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int low = mat[0][0], high = mat[n-1][m-1], res = -1;
        while(low <= high){
            int guess = low + (high - low) / 2;
            int ans = fun(mat, n, m, guess);
            if(ans < k) low = guess+1;
            else{
                res = guess;
                high = guess - 1;
            }
        }
        return res;
    }
}