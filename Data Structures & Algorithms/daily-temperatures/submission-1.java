class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while(st.size()>0 && t[st.peek()] <= t[i]){
                st.pop();
            }
            res[i] = st.size() == 0 ? 0 : (st.peek() - i);
            st.push(i);
        }
        return res;
    }
}
