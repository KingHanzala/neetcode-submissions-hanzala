class Solution {

    public int[] dir = {1,0,-1,0,1};

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int res = 0;
        if(n==0) return res;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    res = Math.max(res, bfs(grid,n,m,i,j,visited));
                }
            }
        }
        return res;
    }

    public boolean isValid(int n, int m, int i, int j){
        if(i<0 || i>=n || j<0 || j>=m) return false;
        return true;
    }

    public int bfs(int[][] grid, int n, int m, int i, int j, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        int cnt = 0;
        while(queue.size()>0){
            int[] curr= queue.poll();
            cnt++;
            for(int x=0; x<4; x++){
                if(isValid(n,m,curr[0] + dir[x], curr[1] + dir[x+1])  && !visited[curr[0] + dir[x]][curr[1] + dir[x+1]] && grid[curr[0] + dir[x]][curr[1] + dir[x+1]] == 1){
                    visited[curr[0] + dir[x]][curr[1] + dir[x+1]] = true;
                    queue.offer(new int[]{curr[0] + dir[x], curr[1] + dir[x+1]});
                }
            }
        }
        return cnt;
    }
}
