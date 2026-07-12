class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0, n, nums, dp);
    }

    public boolean solve(int ind, int n, int[] nums, int[] dp){
        if(ind > n-1) return false;
        if(ind == n-1) {
            dp[ind] = 1;
            return true;
        }
        if(dp[ind]!=-1) return dp[ind] == 1;
        for(int i=1; i<=nums[ind]; i++){
            if((ind+i)<n && solve(ind+i, n, nums, dp)){
                dp[ind] = 1;
                return true;
            }
        }
        dp[ind] = 0;
        return false;
    }
}
