class MinStack {

    Stack<int []> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int min = Math.min(val, getMin());
        st.push(new int[]{val, min});
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        if(st.size() == 0) return Integer.MAX_VALUE;
        return st.peek()[1];
    }
}
