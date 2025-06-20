class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        
        for(int i=1; i<n; i++) {
            int count = 1;
            for(int j=i-1; j>=0; j--) {
                if(nums[i]>nums[j]) {
                    count = Math.max(count, dp[j]+1);
                }
            }
            dp[i] = count;
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}