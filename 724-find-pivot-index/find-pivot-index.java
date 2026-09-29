// class Solution {
//     public int pivotIndex(int[] arr) {
//         int totalSum = 0;
//         for(int ele : arr) totalSum += ele;

//         int prefSum = 0;
//         for(int i = 0; i < arr.length; i++){
//             if( i == 0 ) prefSum = 0;
//             else{
//                 prefSum += arr[i - 1];
//                 int suffSum = totalSum - prefSum - arr[i];
//                 if(prefSum == suffSum) return i;
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int pivotIndex(int[] arr) {
        int totalSum = 0;
        for (int ele : arr) totalSum += ele;

        int prefSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int suffSum = totalSum - prefSum - arr[i];
            if (prefSum == suffSum) return i;

            prefSum += arr[i];
        }
        return -1;
    }
}