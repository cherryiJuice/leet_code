import java.util.*;
class Solution {

    Map<Integer, Integer> memo = new HashMap<>();
    
    public int coinChange(int[] coins, int amount) {
        int result = dfs(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int dfs(int[] coins, int remain) {
        if (remain < 0) return Integer.MAX_VALUE;
        if (remain == 0) return 0;
        if (memo.containsKey(remain)) return memo.get(remain);

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, remain - coin);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }

        memo.put(remain, min);
        return min;
    }
}