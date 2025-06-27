import java.util.*;

class Edge implements Comparable<Edge> {
    int node, cost;
    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge other) {
        // cost로 오름차순 -> 최소 비용순
        return Integer.compare(this.cost, other.cost);
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
 
        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] time : times) {
            graph.get(time[0]).add(new Edge(time[1], time[2]));
        }

        Queue<Edge> pq = new PriorityQueue<>();
        // 시작점
        pq.add(new Edge(k, 0));
        distance[k] = 0;
        
        while(!pq.isEmpty()) {
            // 최소 비용순으로 꺼내기
            Edge cur = pq.remove();
            // 저장된 비용이 더 작으면 넘어가기
            if (distance[cur.node] < cur.cost) continue;

            // 현재 노드와 연결된 노드 탐색
            for(Edge next: graph.get(cur.node)){
                // 다음 비용은 현재 노드의 비용 + 다음 노드의 비용
                int nextCost = distance[cur.node] + next.cost;

                // 이미 저장된 노드의 비용보다 작다면(최소 비용이라면)
                if (nextCost < distance[next.node]){
                    // 방문 예약~~
                    pq.add(new Edge(next.node, nextCost));
                    distance[next.node] = nextCost; // 비용 갱신
                }
            }
        }

        int max = 0;
        for(int i=1; i<=n; i++) {
            if(i != k && distance[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, distance[i]);
        }

        return max;
    }
}