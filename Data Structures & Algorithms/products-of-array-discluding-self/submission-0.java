class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeros = 0;
        int idx = -1;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                zeros++;
                idx = i;
            }
        }
        if(zeros>1){
            return new int[n];
        }
        int prod = 1;
        for(int i=0; i<n; i++){
            if(i == idx) continue;
            prod = prod * nums[i];
        }
        int[] res = new int[n];
        if (zeros == 1){
            res[idx] = prod;
        } else {
            for(int i=0; i<n; i++){
                res[i] = (int) (prod/nums[i]);
            }
        }
        return res;
    }
}  
