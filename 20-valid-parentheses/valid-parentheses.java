class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n =  s.length();
        if (n%2==1) return false;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch =='(' || ch== '{' || ch =='[') st.push(ch);  // Opening Bracket
            else{    // ch Closing Bracket hua to
                if(st.size() == 0) return false;
                char top = st.peek();     // top should be opening bracket
                if(sameStyle(top,ch)) st.pop();
                else return false;
            }
        }
        return (st.size() == 0);
    }

    static boolean sameStyle(char a, char b) {
        if(a=='(' && b==')') return true;
        if(a=='{' && b=='}') return true;
        if(a=='[' && b==']') return true;
        return false;
    }
}