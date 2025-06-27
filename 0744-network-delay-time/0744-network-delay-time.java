import java.util.*;

class Edge implements Comparable<Edge> {
    int node, cost;
    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge other) {
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
        pq.add(new Edge(k, 0));
        distance[k] = 0;
        
        while(!pq.isEmpty()) {
            Edge cur = pq.remove();
            if (distance[cur.node] < cur.cost) continue;

            for(Edge next: graph.get(cur.node)){
                int nextCost = distance[cur.node] + next.cost;
                if (nextCost < distance[next.node]){
                    pq.add(new Edge(next.node, nextCost));
                    distance[next.node] = nextCost;
                }
            }
        }

        int max = 0;
        for(int i=1; i<=n; i++) {
            if(i != k && distance[i] == Integer.MAX_VALUE) return -1;
            if(max<distance[i]) max = distance[i];
        }

        return max;
    }
}