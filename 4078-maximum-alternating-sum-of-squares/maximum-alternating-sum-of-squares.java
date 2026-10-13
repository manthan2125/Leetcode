// class Solution {
//     public long maxAlternatingSum(int[] arr) {
//         int n = arr.length;
//         if(n == 1) return (long)(arr[0]);
//         long sum = 0;
//         Arrays.sort(arr);

//         Integer[] arr2 = new Integer[n];
//         for (int i = 0; i < n; i++) {
//             arr2[i] = arr[i];
//         }

//         Arrays.sort(arr2, (a, b) -> Long.compare(Math.abs((long)b), Math.abs((long)a)));
//         for(int i = 0; i < arr.length; i++){
//             long x = arr2[i];
//             long sq = x*x;
//             if(i < (n+1) / 2) sum -= sq;
//             else sum += sq;
//         }
//         return sum;
//     }
// }

class Solution {
    public long maxAlternatingSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0;

        Arrays.sort(nums);

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> Long.compare(Math.abs((long)b), Math.abs((long)a)));

        for (int i = 0; i < n; i++) {
            long x = arr[i];
            long sq = x * x;

            if (i < (n + 1) / 2) {
                sum += sq;
            } else {
                sum -= sq;
            }
        }

        return sum;
    }
}