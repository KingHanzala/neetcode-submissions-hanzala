class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[] res = new boolean[1];
        res[0] = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                boolean [][] visited = new boolean[n][m];
                StringBuilder sb = new StringBuilder();
                dfs(i, j, n, m, board, visited, sb, word, res);
                if(res[0]) return true;
            }
        }
        return res[0];
    }

    public void dfs(int i, int j, int n, int m, char[][] board, boolean[][] vis, StringBuilder sb, String word, boolean[] possible) {
        if(possible[0] || i>=n || j>=m || i<0 || j<0 || vis[i][j]){
            return;
        }
        
        vis[i][j] = true;
        sb.append(board[i][j]);
        
        if(sb.toString().equals(word)){
            possible[0] = true;
            return;
        }
        
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        for(int x=0; x<4; x++){
            int dx = i + dir[x];
            int dy = j + dir[x+1];
            dfs(dx, dy, n, m, board, vis, sb, word, possible);
        }
        
        sb.deleteCharAt(sb.length() - 1);
        vis[i][j] = false;
    }
}
