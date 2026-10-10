class Solution {
    public int  fun(int m, int n, int guess){
        int row = m, col = 1, count = 0;
        while( row >= 0 && col <= n){
            if(row * col <= guess){
                count += (row);
                col++;
            }
            else row--;
        }
        return count;
    }
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m*n, res = -1;
        while(low <= high){
            int guess = low + (high - low) / 2;
            int ans = fun(m, n, guess);
            if(ans < k) low = guess+1;
            else{
                res = guess;
                high = guess - 1;
            }
        }
        return res;
    }
}