class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1, idx = -1;
        while(low <= high){
            int guess = low + (high - low) / 2;
            if(arr[guess] > arr[n-1]) low = guess + 1;
            else{
                idx = guess;
                high = guess - 1;
            }
        }
        return arr[idx];
    }
}