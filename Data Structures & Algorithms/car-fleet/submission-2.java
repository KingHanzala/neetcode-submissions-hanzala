class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] car = new int[n][2];
        int i=0;
        for(i=0; i<n; i++){
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }
        Arrays.sort(car, (a,b)->Integer.compare(b[0],a[0]));
        float [] time = new float[n];
        i=0;
        for(int [] c: car){
            time[i] = (float)(target - c[0])/c[1];
            i++;
        }
        Stack<Float> st = new Stack<>();
        i=0;
        while(i<n){
            while(!st.isEmpty() && st.peek() >= time[i]){
                i++;
                if(i>=n) break;
            }
            if(i>=n) break;
            st.push(time[i]);
            System.out.println(time[i]);
            i++;
        }
        return st.size();
    }
}
