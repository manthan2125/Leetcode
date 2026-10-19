// class Solution {
//     public int largestRectangleArea(int[] arr) {
//         int n = arr.length;
//         Stack<Integer> st = new Stack<>();
//         int[] nse = new int[n];
//         nse[n-1] = n;
//         st.push(n-1);
//         for(int i = n-2; i >= 0; i--){
//             while(st.size() > 0 && arr[st.peek()] >= arr[i]) st.pop();
//             if(st.size() == 0) nse[i] = n;
//             else nse[i] = st.peek();
//             st.push(i);
//         }

//         while(st.size() > 0) st.pop();

//         int[] pse = new int[n];
//         pse[0] = -1;
//         st.push(0);
//         for(int i = 1; i < n; i++){
//             while(st.size() > 0 && arr[st.peek()] >= arr[i]) st.pop();
//             if(st.size() == 0) pse[i] = -1;
//             else pse[i] = st.peek();
//             st.push(i);
//         }
//         int maxArea = 0;
//         for(int i = 0; i < n; i++){
//             int area = arr[i] * (nse[i] - pse[i] - 1);
//             maxArea = Math.max(area, maxArea);
//         }
//         return maxArea;

//     }
//     public int maximalRectangle(char[][] mat) {
//         int m = mat.length, n = mat[0].length;

//         for(int i = 1; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 if(mat[i][j] == 1) mat[i][j] += mat[i-1][j];
//             }
//         }
//         int max = 0;
//         for(char[] row : mat){
//             int area = largestRectangleArea(row);
//             max = Math.max(area,max);
//         }
//         return max;
//     }
// }


import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && heights[st.peek()] >= curr) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            if (i < n) st.push(i);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }
}