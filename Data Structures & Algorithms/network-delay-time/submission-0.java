class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] adj = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(adj[i], -1);
        }
        for(int[] t: times){
            adj[t[0]][t[1]] = t[2];
        }
        Set<Integer> visited = new HashSet<>();
        //[dst, dist]
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        queue.offer(new int[]{k,0});
        while(queue.size()>0){
            int[] curr = queue.poll();
            int u = curr[0];
            int dist = curr[1];
            if(visited.contains(u))
                continue;
            visited.add(u);
            if(visited.size() == n) {
                return dist;
            }
            for(int v=1; v<=n; v++){
                if(u!=v && adj[u][v]>=0 && !visited.contains(v)){
                    queue.offer(new int[]{v, dist + adj[u][v]});
                }
            }
        }
        return -1;
    }
}
