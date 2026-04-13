class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        int i = 0;
        for(int n: nums){
            if(seen.containsKey(target - n)){
                return new int[]{seen.get(target - n), i};
            }
            if(!seen.containsKey(n)){
                seen.put(n,i);
            }
            i++;
        }
        return new int[]{0,0};
    }
}
