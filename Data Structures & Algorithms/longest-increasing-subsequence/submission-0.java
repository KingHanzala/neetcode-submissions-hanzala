class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp  = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, n, -1, nums, dp);
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
