class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[] res = new boolean[1];
        res[0] = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int curr = 0;
                boolean [][] visited = new boolean[n][m];
                dfs(i, j, n, m, board, visited, curr, word, res);
                if(res[0]) return true;
            }
        }
        return res[0];
    }

    public void dfs(int i, int j, int n, int m, char[][] board, boolean[][] vis, int curr, String word, boolean[] possible) {
        if(possible[0] || i>=n || j>=m || i<0 || j<0 || vis[i][j]){
            return;
        }
         
        if(board[i][j] == word.charAt(curr)){
            curr++;
            if(curr == word.length()){
                possible[0] = true;
                return;
            }
            vis[i][j] = true; 
            int[] dir = new int[]{-1, 0, 1, 0, -1};
            for(int x=0; x<4; x++){
                int dx = i + dir[x];
                int dy = j + dir[x+1];
                dfs(dx, dy, n, m, board, vis, curr, word, possible);
            }
            curr--;
            vis[i][j] = false;
        }
    }
}
