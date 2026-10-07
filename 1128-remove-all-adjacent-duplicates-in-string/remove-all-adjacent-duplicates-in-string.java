class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st =  new Stack<>();
        Stack<Character> st2 =  new Stack<>();
        // StringBuilder res = new StringBuilder();
        String res = "";
        for(int i = 0; i < n; i++){
            if(st.size() == 0) st.push(s.charAt(i));
            else if(st.peek() == s.charAt(i)) st.pop();
            else st.push(s.charAt(i));
        } 
        while(st.size() > 0){
            // res.append(st.peek());
            st2.push(st.pop());
        }
        while(st2.size() > 0){
            res += st2.pop();
        }
        return res;
        // res.reverse();
        // return res.toString();
    }
}