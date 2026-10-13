class Solution {
    public long maxAlternatingSum(int[] nums) {
        // Arrays.sort(nums);
        // int n = nums.length;
        // long sum = 0;

        // Arrays.sort(nums);

        // Integer[] arr = new Integer[n];
        // for (int i = 0; i < n; i++) {
        //     arr[i] = nums[i];
        // }

        // Arrays.sort(arr, (a, b) -> Long.compare(Math.abs((long)b), Math.abs((long)a)));

        // for (int i = 0; i < n; i++) {
        //     long x = arr[i];
        //     long sq = x * x;

        //     if (i < (n + 1) / 2) {
        //         sum += sq;
        //     } else {
        //         sum -= sq;
        //     }
        // }

        int n = nums.length;
        long sum = 0;
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            if(i < n / 2) sum -= arr[i];
            else sum += arr[i];
        }
        return sum;
    }
}