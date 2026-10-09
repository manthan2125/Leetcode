class Solution {
    public int search(int[] a, int x) {
        int n = a.length;
        int low = 0, high = n - 1;
        while(low <= high){
            int guess = low + (high - low ) / 2;
            if(a[guess] == x ) return guess;
            if(a[guess] > a[n-1]){
                if(a[guess] < x) low = guess + 1;
                else{
                    if(a[0] > x) low = guess + 1;
                    else high = guess - 1;
                }
            }
            else{
                if(a[guess]  > x) high = guess - 1;
                else{
                    if(a[n-1] < x) high = guess - 1;
                    else low = guess + 1;
                }
            }
        }
        return -1;
    }
}