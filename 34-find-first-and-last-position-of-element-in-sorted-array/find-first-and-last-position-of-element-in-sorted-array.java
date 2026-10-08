class Solution {
    public int[] searchRange(int[] arr, int x) {
        int[] ans = {-1, -1};
        int n = arr.length;
        if(n == 0) return ans;
        int low = 0, high = n-1, idx = -1;
        while(low <= high){
            int guess = low + (high - low) / 2;
            if(arr[guess] < x) low = guess + 1;
            else if(arr[guess] > x)  high = guess - 1;
            else{ // arr[guess] == x
                idx = guess;
                high = guess - 1;
            }
        }
        ans[0] = idx;
        low = 0; high = n-1; idx = -1;
        while(low <= high){
            int guess = low + (high - low) / 2;
            if(arr[guess] < x) low = guess + 1;
            else if(arr[guess] > x) high = guess - 1;
            else{ // arr[guess] == x
                idx = guess;
                low = guess + 1;
            }
        }
        ans[1] = idx;
        return ans;
    }
}