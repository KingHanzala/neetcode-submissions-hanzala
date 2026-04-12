class Solution {
    public int trap(int[] h) {
        Stack<int[]> stack = new Stack<>();
        int n = h.length;
        int ans = 0;
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && h[i] > stack.peek()[0]){
                int[] curr = stack.pop();
                if(stack.isEmpty()) break;
                ans += (Math.min(stack.peek()[0], h[i]) - curr[0]) *(i-stack.peek()[1]-1);
            }
            stack.push(new int[]{h[i], i});
        }
        return ans;
    }
}
