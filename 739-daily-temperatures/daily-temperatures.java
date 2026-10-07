class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        res[n-1] = 0;
        st.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(st.size() > 0 && temp[st.peek()] <= temp[i]) st.pop();
            if(st.size() == 0) res[i] = 0;
            else res[i] = (st.peek() - i);
            st.push(i);
        }
        return res;
    }
}