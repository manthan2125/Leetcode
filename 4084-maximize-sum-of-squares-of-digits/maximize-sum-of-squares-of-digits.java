class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9) {
            return "";
        }

        // int k = sum / 9;
        // int rem = sum % 9;

        StringBuilder ans = new StringBuilder();

        for(int i = 0 ;i < num; i++){
            if(sum >= 9){
            ans.append(9);
            sum = sum - 9;
        }
        else{
            ans.append(sum);
            sum = 0;
        }
        }

        return ans.toString();
    }
}