class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReachable = 0;
        for(int i=0; i<n; i++){
            if(i<=maxReachable){
                maxReachable = Math.max(maxReachable, i + nums[i]);
                if(maxReachable >= n-1){
                    return true;
                }
            }
        }
        return false;
    }
}
