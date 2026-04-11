class Solution {
    class DSU {
        int n;
        public Map<Integer, Integer> parent;
        public Map<Integer, Integer> size;
        int maxSize;

        DSU(int n, int[] nums){
            parent = new HashMap<>();
            size = new HashMap<>();
            maxSize = 1;
        }

        public int findParent(int u){
            if(!parent.containsKey(u)) {
                parent.put(u,u);
                size.put(u, 1);
                return u;
            }
            if (parent.get(u) != u) {
                parent.put(u, findParent(parent.get(u)));
            }
            return parent.get(u);
        }

        public void union(int u, int v) {
            u = findParent(u);
            v = findParent(v);
            if(u == v) return;
            if (size.get(v) > size.get(u)) {
                parent.put(u, v);
                size.put(v, size.get(v) + size.get(u));
            } else {
                parent.put(v, u);
                size.put(u, size.get(v) + size.get(u));
            }
            int root = findParent(u);
            maxSize = Math.max(maxSize, size.get(root));
        }

    }
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        DSU d = new DSU(n, nums);
        for(int i=0; i<n; i++){
            int curr = nums[i];
            if(d.parent.containsKey(curr)) continue;
            d.findParent(curr);
            if(d.parent.containsKey(curr - 1)){
                d.union(curr-1, curr);
            }
            if(d.parent.containsKey(curr + 1)){
                d.union(curr+1, curr);
            }
        }

        return d.maxSize;
        
    }
}
