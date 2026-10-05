class Solution {
    public boolean judgeSquareSum(int c) {
        int num  = (int) Math.sqrt(c);
        int i = 0, j = num;
        while(i <= j){
            long sum = (long)i*i + (long)j*j;
            if(sum < c) i++;
            else if(sum == c) return true;
            else j--; 
        }
        return false;
    }
}