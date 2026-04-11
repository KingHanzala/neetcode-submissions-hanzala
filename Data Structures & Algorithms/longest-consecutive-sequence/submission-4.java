class Solution {
    class DSU {
        int n;
        int [] parent;
        int [] size;
        int maxSize;

        DSU(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
            maxSize = 1;
        }

        public int findParent(int u){
            if(u == parent[u]) return u;
            return parent[u] = findParent(parent[u]);
        }

        public void union(int u, int v) {
            u = findParent(u);
            v = findParent(v);
            if(u == v) return;
            if (size[v] > size[u]) {
                parent[u] = v;
                size[v] = size[u] + size[v];
            } else {
                parent[v] = u;
                size[u] = size[u] + size[v];
            }
            int root = findParent(u);
            maxSize = Math.max(maxSize, size[root]);
        }

    }
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        DSU d = new DSU(n);
        Set<Integer> seen = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int curr = nums[i];
            if(seen.contains(curr)) continue;
            if(seen.contains(curr - 1)){
                d.union(map.get(curr-1), i);
            }
            if(seen.contains(curr + 1)){
                d.union(map.get(curr + 1), i);
            }
            seen.add(curr);
            map.put(curr, i);
        }

        return d.maxSize;
        
    }
}
