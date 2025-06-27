import java.util.*;

class Edge implements Comparable<Edge>{
    double cost; int node;

    Edge(int node, double cost) {
        this.cost = cost;
        this.node = node;
    }

    public int compareTo(Edge other) {
        return Double.compare(other.cost, this.cost);
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        double[] costs = new double[n];

        for(int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            int cur = edges[i][0];
            int next = edges[i][1];
            graph.get(cur)
                .add(new Edge(next, succProb[i]));
            graph.get(next)
                .add(new Edge(cur, succProb[i]));
        }

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start_node, 1));
        costs[start_node] = 1;

        while(!pq.isEmpty()) {
            Edge cur = pq.remove();

            if(cur.node == end_node) return costs[end_node];
            if(cur.cost < costs[cur.node]) continue;

            for(Edge next: graph.get(cur.node)) {

                double nextcost = next.cost * costs[cur.node];
                if(nextcost > costs[next.node]) {
                    pq.add(new Edge(next.node, nextcost));
                    costs[next.node] = nextcost;
                }
            }
        }

        return costs[end_node];
    }
}