import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                if (!bfs(i, graph, visited)) return false;
            }       
        }
        return true;
    }

    private boolean bfs(int i, int[][] graph, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);

        while(!q.isEmpty()) {
            int current = q.poll();
            for(int next : graph[current]) {
                if(visited[next] == -1) {
                    q.offer(next);
                    visited[next] = -visited[current];
                } else {
                    if(visited[next] == visited[current]) return false;
                }
            }
        }
        return true;
    }
}