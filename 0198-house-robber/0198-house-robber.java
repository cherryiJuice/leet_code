class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        if(n == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for(int i=2; i<n; i++) {
            for(int j=0; j<i-1; j++) {
                dp[i] = Math.max(nums[i]+ dp[j], dp[i]);
            }
        }

        dp[n] = Math.max(dp[n-1], dp[n-2]);
        return dp[n];
    }
}