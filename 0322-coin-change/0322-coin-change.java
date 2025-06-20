class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int[] dp = new int[amount+1];

        for(int i=0; i<coins.length; i++) {
            if(coins[i] < amount)
                dp[coins[i]] = 1;
            if(amount == coins[i]) return 1;
        }

        for(int i=1; i<amount; i++) {
            if(dp[i] != 0) {
                for(int j=0; j<coins.length; j++) {
                    if(coins[j] < amount) {
                        int sum = i + coins[j];
                        if(sum <= amount && 
                        (dp[sum] == 0 || dp[sum] >= dp[i] + 1)){
                            dp[sum] = dp[i] + 1;
                        }
                    }   
                }
            }
        }

        
        if(dp[amount] == 0) return -1;
        return dp[amount];
    }
}