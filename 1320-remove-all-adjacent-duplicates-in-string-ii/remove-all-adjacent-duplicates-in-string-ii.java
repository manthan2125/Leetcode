class Pair {
    char ch;
    int count;

    Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        int n = s.length();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(st.size() == 0) st.push(new Pair(ch, 1));
            else if(st.peek().ch != ch) st.push(new Pair(ch, 1));
            else{
                if(st.peek().count < k-1){
                    Pair p = st.peek();
                    st.pop();
                    st.push(new Pair(p.ch, p.count+1));
                }
                else st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(st.size() > 0){
            Pair p = st.peek();
            st.pop();
            while(p.count > 0){
                sb.append(p.ch);
                p.count--;
            }
        }
        sb.reverse();
        return sb.toString();
    }
}