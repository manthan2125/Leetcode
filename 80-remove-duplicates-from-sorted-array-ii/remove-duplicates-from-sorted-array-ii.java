class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0, j = 1, unique = 1, count = 1;
        while(j < n){
            if(nums[j] == nums[j-1]){
                if(count < 2){
                    nums[i+1] = nums[j];
                    i++;
                    j++;
                    count++;
                    unique++;
                }
                else j++;
            }
            else{
                nums[i+1] = nums[j];
                i++;
                j++;
                count = 1;
                unique++;
            }
        }
        return unique;
    }
}