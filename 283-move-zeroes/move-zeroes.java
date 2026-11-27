class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        int low = 0, high = 0;
        while(high < n){
            if(nums[high] != 0){
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
            }
            high++;
        }
        return;
    }
}