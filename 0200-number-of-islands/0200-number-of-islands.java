class Solution {
    boolean[][] visited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int answer = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;
                    answer++;
                    dfs(i, j, grid);
                }
            }
        }
        return answer;
    }

    private void dfs(int x, int y, char[][] grid) {
        for(int i=0; i<4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx >= 0 && ny >= 0 && nx < visited.length && ny < visited[0].length
                && !visited[nx][ny] && grid[nx][ny] == '1') {
                visited[nx][ny] = true;
                dfs(nx, ny, grid);
            }
        }
    }
}