class Solution {
    boolean answer = false;
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                visited = new boolean[n][m];
                visited[i][j] = true;
                dfs(board, word, board[i][j]+"", i, j);
            }
        }
        
        return answer;
    }

    private void dfs(char[][] board, String target, String cur, int x, int y) {
        if(answer) return;
        
        if(cur.length() > target.length()) return;
        if(cur.equals(target)) {
            answer = true;
            return;
        }
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;

            if(!visited[nx][ny]) {
                visited[nx][ny]=true;
                dfs(board, target, cur+board[nx][ny], nx, ny);
                visited[nx][ny]=false;
            }
        }
        
    }
}