class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st =  new Stack<>();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(st.size() == 0) st.push(s.charAt(i));
            else if(st.peek() == s.charAt(i)) st.pop();
            else st.push(s.charAt(i));
        } 
        while(st.size() > 0){
            res.append(st.peek());
            st.pop();
        }
        res.reverse();
        return res.toString();
    }
}