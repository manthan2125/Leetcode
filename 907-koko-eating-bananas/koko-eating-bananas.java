class Solution {
    public long hours(int[] a, int n, int speed) {
        long h = 0;
        for (int i = 0; i < n; i++) {
            h += a[i] / speed;
            if (a[i] % speed != 0) h++;
        }
    return h;
    }
    public int maximum(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= max){
                max = arr[i];
            }
        }
        return max;
    }
    public int minEatingSpeed(int[] arr, int h) {
        int n =  arr.length;
        int low = 1, high = maximum(arr), res = -1;
        while(low <= high){
            int guess = low + (high - low)/2;
            long hour = hours(arr, n, guess);
            if(hour > h) low = guess + 1;
            else {
                res = guess;
                high = guess - 1;
            }
        }
        return res;
    }
}