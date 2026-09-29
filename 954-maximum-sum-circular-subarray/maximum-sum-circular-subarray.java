// class Solution {
//     public int maxSubarraySumCircular(int[] nums) {
//         int maxSum = nums[0];
//         int minSum = nums[0];
//         int res = nums[0];
//         int totalSum = 0;

//         for(int i : nums){
//             totalSum += i;
//         }

//         for(int i = 1; i < nums.length; i++){
//             maxSum = Math.max(nums[i], nums[i] + maxSum);
//             minSum = Math.min(nums[i], nums[i] + minSum);
//             res = Math.max(res, maxSum);
//         }
//         if(res < 0) return res;

        
//         return Math.max(res, (totalSum - minSum));
//     }
// }

// class Solution {
//     public int maxSubarraySumCircular(int[] nums) {
//         int maxSum = nums[0];
//         int minSum = nums[0];
//         int res = nums[0];
//         int totalSum = 0;

//         for (int i : nums) {
//             totalSum += i;
//         }

//         for (int i = 1; i < nums.length; i++) {
//             maxSum = Math.max(nums[i], nums[i] + maxSum);
//             minSum = Math.min(nums[i], nums[i] + minSum);
//             res = Math.max(res, maxSum);
//         }

//         if (res < 0) {
//             return res;
//         }

//         return Math.max(res, totalSum - minSum);
//     }
// }

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int maxRes = nums[0];
        int minRes = nums[0];
        int totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];

            maxSum = Math.max(nums[i], nums[i] + maxSum);
            minSum = Math.min(nums[i], nums[i] + minSum);

            maxRes = Math.max(maxRes, maxSum);
            minRes = Math.min(minRes, minSum);
        }

        if (maxRes < 0) {
            return maxRes;
        }

        return Math.max(maxRes, totalSum - minRes);
    }
}