import java.util.*;

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int[] dx = {0, 1, -1, 0, 1, -1, 1, -1};
        int[] dy = {1, 0, 0, -1, 1, -1, -1, 1};
        int n = board.length, m = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        int ex = click[0], ey = click[1];
        char k = board[ex][ey];
        if(board[ex][ey] == 'M') {
            board[ex][ey] = 'X';
            return board;
        }
        q.add(new int[]{ex, ey});

        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0], y = poll[1];

            int count = 0;
            for(int i=0; i<8; i++) {
                int nx = x + dx[i], ny = y + dy[i]; // 다음 것
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if(board[nx][ny] == 'M') {
                    count++; 
                }
            }

            if (count > 0) {
                // 주변에 지뢰가 하나라도 있으면 숫자만 표시하고 더 탐색하지 않음
                board[x][y] = (char) (count + '0');
                continue;
            }

            board[x][y] = 'B';
            for(int i=0; i<8; i++) {
                int nx = x + dx[i], ny = y + dy[i]; // 다음 것

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                if(board[nx][ny] == 'E') {
                    board[nx][ny] = 'B';
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return board;
    }
}