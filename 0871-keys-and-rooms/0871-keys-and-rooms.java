import java.util.*;

class Solution {
    boolean[] visited;
    private void dfs(List<List<Integer>> rooms, int cur) {
        visited[cur] = true;
        for(int next: rooms.get(cur)) {
            if(!visited[next]) {
                dfs(rooms, next);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(rooms, 0);
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }
}