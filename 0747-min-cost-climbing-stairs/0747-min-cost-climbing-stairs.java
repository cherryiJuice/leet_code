import java.util.*;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = cost[0]; dp[1] = cost[1];
        
        for(int i=2; i<n; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }

        dp[n] = Math.min(dp[n-1], dp[n-2]);

        return dp[n];
    }
}