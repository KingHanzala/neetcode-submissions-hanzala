class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp =new int[n]; // dp[i] -> min jumps to reach i
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(j + nums[j] >= i && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
            System.out.println(dp[i]);
        }
        return dp[n-1];
    }
}
