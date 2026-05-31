class Solution {
    public int solve(int i, int j, int[] nums, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        for(int x=i; x<=j; x++) {
            int val = nums[i-1] * nums[x] * nums[j+1];
            int s = val + solve(i, x-1, nums, dp) + solve(x+1, j, nums, dp);
            dp[i][j] = Math.max(dp[i][j], s);
        }
        return dp[i][j];
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        for(int i=1; i<=n; i++){
            arr[i] = nums[i-1];
        }
        arr[0]=1;
        arr[n+1]=1;
        int[][] dp = new int[n+2][n+2];
        for(int i=0; i<n+2; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(1,n,arr,dp);
    }
}
