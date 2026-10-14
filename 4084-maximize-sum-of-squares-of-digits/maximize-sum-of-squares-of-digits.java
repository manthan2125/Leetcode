class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9) {
            return "";
        }

        int k = sum / 9;
        int rem = sum % 9;

        StringBuilder ans = new StringBuilder("9".repeat(k));

        if (rem > 0) {
            ans.append(rem);
        }

        while (ans.length() < num) {
            ans.append('0');
        }

        return ans.toString();
    }
}