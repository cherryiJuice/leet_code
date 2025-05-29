import java.util.*;
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];
        int L = 0, total = 0;
        q.add(0);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int poll = total = q.poll();

                for(int j=0; j<coins.length; j++) {
                    int next = poll + coins[j];
                    if(next == amount) {
                        return L + 1;
                    }
                    if(next <= amount && !visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            L++;
        }
        if(total != amount) return -1;
        
        return L;
    }
}