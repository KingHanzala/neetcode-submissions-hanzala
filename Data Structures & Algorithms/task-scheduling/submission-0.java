class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        int size = tasks.length;
        for(char task: tasks){
            cnt[task - 'A']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[1] - a[1]);
        for(int i=0; i<26; i++){
            if(cnt[i]>0){
                pq.offer(new int[]{i,cnt[i]});
            }
        }
        Queue<int[]> wait = new LinkedList<>();
        int cycles = 0;
        while(!pq.isEmpty() || !wait.isEmpty()){
            if(!wait.isEmpty() && wait.peek()[2] <= cycles){
                pq.offer(new int[]{wait.peek()[0], wait.peek()[1]});
                wait.poll();
            }
            if(!pq.isEmpty()){
                int[] curr = pq.poll();
                if(curr[1]>1){
                    wait.offer(new int[]{curr[0], curr[1] - 1, cycles+n+1});
                }
            }
            cycles++;
        }
        return cycles;
    }
}
