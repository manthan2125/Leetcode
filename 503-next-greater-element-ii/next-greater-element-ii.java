class Solution {
    public int[] nextGreaterElements(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-2; i >=0; i--) st.push(a[i]);

        for(int i = n-1; i >= 0; i--){
            while(st.size() > 0 && st.peek() <= a[i]) st.pop();
            if(st.size() == 0) res[i] = -1;
            else res[i] = st.peek();
            st.push(a[i]);
        }
        return res;
    }
}