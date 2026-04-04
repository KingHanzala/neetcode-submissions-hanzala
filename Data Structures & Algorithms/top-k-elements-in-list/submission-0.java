class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(b[1],a[1]));
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(int key: map.keySet()){
            pq.offer(new int[]{key, map.get(key)});
        }
        int[] res = new int[k];
        int i = 0;
        while(k>0){
            res[i++] = pq.poll()[0];
            k--;
        }
        return res;
    }
}
