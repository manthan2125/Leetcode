class Solution {
    public int sumOfSquares(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            int ele = arr[i];
            if(n % (i+1) == 0) sum += ele * ele;
        }
        return sum;
    }
}