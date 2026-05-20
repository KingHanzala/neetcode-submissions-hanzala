class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp  = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int solve(int i, int n, int prev, int[] nums, int[][] dp){
        if(i==n){
            return 0;
        }
        if(prev!=-1 && dp[i][prev+1]!=-1) return dp[i][prev+1];
        int pick = 0;
        if(prev==-1 || nums[i] > nums[prev]){
            pick = 1 + solve(i+1, n, i, nums, dp);
        }
        int notPick = solve(i+1, n, prev, nums, dp);
        return dp[i][prev+1] = Math.max(pick, notPick);
    }
}
