class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        if(st.size() == 0) min = (long)val;

        if((long)val >= min) st.push((long)val);
        else{
            st.push((long)val + (long)val - min);
            min = (long)val;
        }
    }
    
    public void pop() {
        if(st.peek() < min) min = min + (min - st.peek());
        st.pop();
    }
    
    public int top() {
        long a  = st.peek();
        if(a < min) return (int)min;
        else return (int)a;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */