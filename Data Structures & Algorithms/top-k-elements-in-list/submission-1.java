class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer> sortedKeys = new ArrayList<>(map.keySet());
        sortedKeys.sort((a,b) -> map.get(b) - map.get(a));
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = sortedKeys.get(i);
        }
        return res;
    }
}
