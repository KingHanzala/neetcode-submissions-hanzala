class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
        Stack<int []> st = new Stack<>();
        int i = 0;
        int n = intervals.length;
        while(i<n){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(st.size() > 0 && i<n && st.peek()[1] >= intervals[i][0]){
                start = Math.min(start, st.peek()[0]);
                end = Math.max(end, st.peek()[1]);
                st.pop();
            }
            st.push(new int[]{start, end});
            i++;
        }
        n = st.size();
        int[][] res = new int[n][2];
        i=n-1;
        while(st.size()>0){
            res[i] = st.pop();
            i--;
        }
        return res;
    }

}
